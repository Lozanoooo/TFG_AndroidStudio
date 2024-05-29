package com.example.tfg_tpv.Producto;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tfg_tpv.R;

public class ProductoAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_acivity);

        ImageView imageView = findViewById(R.id.imageView);
        TextView title = findViewById(R.id.title);
        TextView price = findViewById(R.id.price);

        // Obtén los extras del Intent
        int imageResource = getIntent().getIntExtra("imageResource", 0);
        String titulo = getIntent().getStringExtra("title");
        double precio = getIntent().getDoubleExtra("price", 0.0);

        // Actualiza las vistas con los valores obtenidos
        imageView.setImageResource(imageResource);
        title.setText(titulo);
        price.setText(String.valueOf(precio + "€"));
    }
}