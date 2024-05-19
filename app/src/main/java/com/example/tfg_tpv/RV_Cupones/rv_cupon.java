package com.example.tfg_tpv.RV_Cupones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tfg_tpv.R;

import java.util.List;

public class rv_cupon extends RecyclerView.Adapter<rv_cupon.CouponViewHolder> {

    private List<String> mDataset;

    public static class CouponViewHolder extends RecyclerView.ViewHolder {
        public ImageView couponImage;
        public TextView couponTitle;
        public TextView couponDescription;

        public CouponViewHolder(View v) {
            super(v);
            couponImage = v.findViewById(R.id.couponImage);
            couponTitle = v.findViewById(R.id.couponTitle);
            couponDescription = v.findViewById(R.id.couponDescription);
        }
    }

    public rv_cupon(List<String> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public rv_cupon.CouponViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_cupones, parent, false);
        return new CouponViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CouponViewHolder holder, int position) {
        // Aquí puedes personalizar los datos de cada elemento si tienes una lista de datos
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}