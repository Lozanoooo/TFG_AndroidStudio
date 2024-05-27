package com.example.tfg_tpv.RV_Ofertas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tfg_tpv.R;
import java.util.List;

public class rv_ofertas extends RecyclerView.Adapter<rv_ofertas.MyViewHolder> {

    private List<oferta> mDataset; // Cambiado a lista de Oferta

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

    public rv_ofertas(List<oferta> myDataset) { // Cambiado a lista de Oferta
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public rv_ofertas.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_ofertas, parent, false);
        return new rv_ofertas.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(rv_ofertas.MyViewHolder holder, int position) {
        oferta oferta = mDataset.get(position); // Obtén la oferta en la posición actual
        holder.imageView.setImageResource(oferta.getImageResource()); // Establece la imagen
        holder.title.setText(oferta.getTitulo()); // Establece el título
        holder.price.setText(String.valueOf(oferta.getPrecio())); // Establece el precio
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}