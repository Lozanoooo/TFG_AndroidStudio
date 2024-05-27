package com.example.tfg_tpv.RV_Ofertas;

public class oferta {
    private int imageResource;
    private String title;

    public oferta(int imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }
}