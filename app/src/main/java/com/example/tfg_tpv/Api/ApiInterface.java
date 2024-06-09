package com.example.tfg_tpv.Api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("/auth/cliente")
    Call<ResponseBody> loginUser(@Body Map<String, String> loginData);

    @POST("/clientes/{id}")
    Call<ResponseBody> registerUser(@Body Map<String, String> registerData);

    // En ApiInterface.java
    @GET("/clientes/{id}")
    Call<ProfileData> obtenerPerfil(@Path("id") String idCliente);
}
