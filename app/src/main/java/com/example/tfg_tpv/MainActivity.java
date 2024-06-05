package com.example.tfg_tpv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.View;


import com.example.tfg_tpv.Fragmentos.Fragmento1;
import com.example.tfg_tpv.Fragmentos.Fragmento3;
import com.example.tfg_tpv.Profile.Profile;
import com.example.tfg_tpv.R;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView1 = findViewById(R.id.bottom_navigation);

        navigationView1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.ofertas) {
                    Fragmento1 fragmento1 = new Fragmento1();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmento1).commit();
                } else if (item.getItemId() == R.id.folletos) {
                    Fragmento3 fragmento3 = new Fragmento3();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmento3).commit();
                }
                return true;
            }
        });
    }

    public void abrirPerfil(View view) {
        Profile fragmento4 = new Profile();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmento4).commit();
    }
}