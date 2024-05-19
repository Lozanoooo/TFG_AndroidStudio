package com.example.tfg_tpv.RV_Folletos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tfg_tpv.R;

import java.util.List;

public class rv_folletos extends RecyclerView.Adapter<rv_folletos.MyViewHolder> {

    private List<String> mDataset;

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

    public rv_folletos(List<String> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public rv_folletos.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_folletos, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // Aquí puedes personalizar los datos de cada elemento si tienes una lista de datos
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}