package com.example.tfg_tpv.Api;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("idCliente")
    private String idCliente;
    @SerializedName("contrasena")
    private String contrasena;

    public LoginData(String idCliente, String contrasena) {
        this.idCliente = idCliente;
        this.contrasena = contrasena;
    }

    public String getidCliente() {return idCliente;}

    public void setidCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}