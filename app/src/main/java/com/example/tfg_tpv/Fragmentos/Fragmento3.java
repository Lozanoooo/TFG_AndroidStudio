package com.example.tfg_tpv.Fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento3, container, false);

        Button button1 = view.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatalogoElectronica(v);
            }
        });

        Button button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatalogoAlimentacion(v);
            }
        });

        return view;
    }

    public void CatalogoAlimentacion(View view) {
        Toast.makeText(getActivity(), "Catalogo de Alimentacion", Toast.LENGTH_SHORT).show();
    }

    public void CatalogoElectronica(View view) {
        Toast.makeText(getActivity(), "Catalogo de Electronica", Toast.LENGTH_SHORT).show();
    }
}