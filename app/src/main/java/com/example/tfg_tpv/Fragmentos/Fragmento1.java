package com.example.tfg_tpv.Fragmentos;

import android.os.Bundle;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tfg_tpv.R;
import com.example.tfg_tpv.RV_Ofertas.oferta;
import com.example.tfg_tpv.RV_Ofertas.rv_ofertas;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;
import java.util.List;

public class Fragmento1 extends Fragment implements OnMapReadyCallback {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private MapView mapView;
    private GoogleMap gmap;

    public Fragmento1() {
        // Required empty public constructor
    }

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

        String[] nombresProductos = {"Air Frayer", "Yogurt de fresa ", "PS5", "Patatas pringles", "Carne de vacuno/1kg", "Queso Semicurado/1kg ", "LG UHD- Smart TV 4K", "Barbacoa portatil sunja", "Espárragos verdes en bote | Calidad Primera | Carretilla"};
        double[] preciosProductos = {120.99, 0.99, 399.99, 1.99, 5.99, 4.95, 899.99, 19.99, 2.95};

        List<oferta> myDataset = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            int imageResource = getResources().getIdentifier("image" + i, "drawable", getActivity().getPackageName());
            String nombre = nombresProductos[i-1];
            double precio = preciosProductos[i-1];
            myDataset.add(new oferta(imageResource, nombre, nombre, precio)); // Usamos 'nombre' en lugar de "Producto " + i
        }

        RecyclerView.Adapter mAdapter = new rv_ofertas(myDataset, getContext());
        recyclerView.setAdapter(mAdapter);

        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        return view;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}