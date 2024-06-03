package com.example.tfg_tpv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tfg_tpv.Fragmentos.Fragmento1;
import com.example.tfg_tpv.Fragmentos.Fragmento3;
import com.example.tfg_tpv.Profile.Profile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragmento1 fragmento1 = new Fragmento1();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmento1).commit();
    }

    public void Home(View view) {
        Fragmento1 fragmento1 = new Fragmento1();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmento1).commit();
    }

    public void folletos(View view) {
        Fragmento3 fragmento3 = new Fragmento3();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmento3).commit();
    }

    public void abrirPerfil(View view) {
        Profile fragmento4 = new Profile();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmento4).commit();

    }
}