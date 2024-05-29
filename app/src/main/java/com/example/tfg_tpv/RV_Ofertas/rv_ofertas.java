package com.example.tfg_tpv.RV_Ofertas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tfg_tpv.Producto.ProductoAcivity;
import com.example.tfg_tpv.R;
import java.util.List;

public class rv_ofertas extends RecyclerView.Adapter<rv_ofertas.MyViewHolder> {

    private List<oferta> mDataset;
    private Context context;

    public rv_ofertas(List<oferta> myDataset, Context context) {
        this.mDataset = myDataset;
        this.context = context;
    }

    @NonNull
    @Override
    public rv_ofertas.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_ofertas, parent, false);
        return new rv_ofertas.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(rv_ofertas.MyViewHolder holder, int position) {
        oferta oferta = mDataset.get(position);
        holder.imageView.setImageResource(oferta.getImageResource());
        holder.title.setText(oferta.getTitulo());
        holder.price.setText(String.valueOf(oferta.getPrecio() + "€"));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductoAcivity.class);
            intent.putExtra("imageResource", oferta.getImageResource());
            intent.putExtra("title", oferta.getTitulo());
            intent.putExtra("price", oferta.getPrecio());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title;
        public TextView price;
        public MyViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.imageView);
            title = v.findViewById(R.id.title);
            price = v.findViewById(R.id.price);
        }
    }
}