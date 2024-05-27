package com.example.tfg_tpv.Fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tfg_tpv.R;
import com.example.tfg_tpv.RV_Ofertas.oferta;
import com.example.tfg_tpv.RV_Ofertas.rv_ofertas;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragmento1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmento1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento1 newInstance(String param1, String param2) {
        Fragmento1 fragment = new Fragmento1();
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
        View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3); // 2 columnas
        recyclerView.setLayoutManager(layoutManager);

        String[] nombresProductos = {"Air Frayer", "Yogurt bebido de fresa ", "PS5", "Producto 4", "Producto 5", "Producto 6", "Producto 7", "Producto 8", "Producto 9"};
        double[] preciosProductos = {120.99, 0.991, 399.99, 400.0, 500.0, 600.0, 700.0, 800.0, 900.0};

        List<oferta> myDataset = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            int imageResource = getResources().getIdentifier("image" + i, "drawable", getActivity().getPackageName());
            String nombre = nombresProductos[i-1];
            double precio = preciosProductos[i-1];
            myDataset.add(new oferta(imageResource, "Producto " + i, nombre, precio));
        }

        RecyclerView.Adapter mAdapter = new rv_ofertas(myDataset);
        recyclerView.setAdapter(mAdapter);

        return view;
    }
}