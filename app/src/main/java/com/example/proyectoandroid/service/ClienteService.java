package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.Cliente;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClienteService {


    @POST("registrarcliente")
    Call<String> registrarcliente(
            @Body Cliente cliente
    );

    @POST("/logincliente")
    Call<Integer> logincliente(
            @Body Cliente cliente
    );

}
