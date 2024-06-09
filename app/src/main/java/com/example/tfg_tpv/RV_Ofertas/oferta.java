package com.example.tfg_tpv.RV_Ofertas;

public class oferta {
    private int imageResource;
    private String titulo;
    private String nombre; // Nuevo campo
    private double precio; // Nuevo campo

    public oferta(int imageResource, String titulo, String nombre, double precio) {
        this.imageResource = imageResource;
        this.titulo = titulo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y setters

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}