package com.example.tfg_tpv;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Folletos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragmento3);
    }

    public void CatalogoAlimentacion(View view) {
        Toast.makeText(this, "Catalogo de Alimentacmmmmmmmmmmmmion", Toast.LENGTH_SHORT).show();

    }

    public void CatalogoElectronica(View view) {
        Toast.makeText(this, "Catalogo de Electronica", Toast.LENGTH_SHORT).show();

    }

}


