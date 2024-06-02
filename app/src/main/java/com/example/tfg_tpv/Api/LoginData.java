package com.example.tfg_tpv.Api;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("ID_Cliente")
    private String ID_Cliente;
    @SerializedName("contrasena")
    private String contrasena;

    public LoginData(String ID_Cliente, String contrasena) {
        this.ID_Cliente = ID_Cliente;
        this.contrasena = contrasena;
    }

    public String getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}