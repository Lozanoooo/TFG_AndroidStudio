package com.example.tfg_tpv.Api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("/auth/cliente")
    Call<ResponseBody> loginUser(@Body Map<String, String> loginData);

    @POST("/clientes/{id}")
    Call<ResponseBody> registerUser(@Body Map<String, String> registerData);

}
