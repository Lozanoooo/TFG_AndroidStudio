package com.example.tfg_tpv.Profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tfg_tpv.Api.ApiInterface;
import com.example.tfg_tpv.Api.ProfileData;
import com.example.tfg_tpv.Api.RetrofitClient;
import com.example.tfg_tpv.R;
import retrofit2.Retrofit;

public class Profile extends Fragment {

    private TextView id_user, nom_user, Ape_user, tlf_user, dir_user, cif_user, CElec_user, pwd_user;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Profile() {
    }

    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        id_user = view.findViewById(R.id.id_user);
        nom_user = view.findViewById(R.id.nom_user);
        Ape_user = view.findViewById(R.id.Ape_user);
        tlf_user = view.findViewById(R.id.tlf_user);
        dir_user = view.findViewById(R.id.dir_user);
        cif_user = view.findViewById(R.id.cif_user);
        CElec_user = view.findViewById(R.id.CElec_user);
        pwd_user = view.findViewById(R.id.pwd_user);

        Retrofit retrofit = RetrofitClient.getClient("http://10.0.2.2:8080/");
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        // Obtener el ID del usuario de las preferencias compartidas
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USUARIOS_INICIO", Context.MODE_PRIVATE);
        String idCliente = sharedPreferences.getString("idCliente", "");

        // Llamar al método para obtener los datos del perfil del usuario
        retrofit2.Call<ProfileData> call = apiInterface.obtenerPerfil(idCliente);

        call.enqueue(new retrofit2.Callback<ProfileData>() {
            @Override
            public void onResponse(retrofit2.Call<ProfileData> call, retrofit2.Response<ProfileData> response) {
                if (response.isSuccessful()) {
                    ProfileData profileData = response.body();
                    id_user.setText(profileData.getIdCliente());
                    nom_user.setText(profileData.getNombre());
                    Ape_user.setText(profileData.getApellido());
                    tlf_user.setText(profileData.getTelefono());
                    dir_user.setText(profileData.getDireccion());
                    cif_user.setText(profileData.getCif());
                    CElec_user.setText(profileData.getEmail());
                    pwd_user.setText(profileData.getContrasena());
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ProfileData> call, Throwable t) {
                Toast.makeText(getActivity(), "Error al obtener los datos del perfil", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}