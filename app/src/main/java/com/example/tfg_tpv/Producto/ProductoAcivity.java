package com.example.tfg_tpv.Producto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tfg_tpv.MainActivity;
import com.example.tfg_tpv.R;

public class ProductoAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_acivity);

        ImageView imageView = findViewById(R.id.imageView);
        TextView tituloView = findViewById(R.id.titulo);
        TextView precioView = findViewById(R.id.precio);

        // Obtén los extras del Intent
        int imageResource = getIntent().getIntExtra("imageResource", 0);
        String titulo = getIntent().getStringExtra("title");
        double precio = getIntent().getDoubleExtra("price", 0.0);

        // Actualiza las vistas con los valores obtenidos
        imageView.setImageResource(imageResource);
        tituloView.setText(titulo);
        precioView.setText(String.valueOf(precio + "€"));
    }

    public void atras(View view) {
       Intent intent = new Intent(this, MainActivity.class);
         startActivity(intent);
    }
}