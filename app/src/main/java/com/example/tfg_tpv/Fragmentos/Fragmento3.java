package com.example.tfg_tpv.Fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.tfg_tpv.Folletos.WebViewActivity;
import com.example.tfg_tpv.R;

public class Fragmento3 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Fragmento3() {
        // Required empty public constructor
    }

    public static Fragmento3 newInstance(String param1, String param2) {
        Fragmento3 fragment = new Fragmento3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento3, container, false);

        final WebView webView1 = view.findViewById(R.id.webView1);//se pone final para que se pueda acceder desde el boton, porque es una clase anonima
        final WebView webView2 = view.findViewById(R.id.webView2);

       Button button1 = view.findViewById(R.id.button1);
button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("url", "///android_asset/Folleto_electro.html");
        startActivity(intent);
    }
});

Button button2 = view.findViewById(R.id.button2);
button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("url", "///android_asset/Folleto_alim.html");
        startActivity(intent);
    }
});

        return view;
    }
}
