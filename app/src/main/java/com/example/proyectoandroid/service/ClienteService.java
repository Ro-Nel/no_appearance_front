package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.Cliente;
import com.example.proyectoandroid.model.Match;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface ClienteService {


    @POST("registrarcliente")
    Call<String> registrarcliente(
            @Body Cliente cliente
    );

    @POST("/logincliente")
    Call<Integer> logincliente(
            @Body Cliente cliente
    );

    @GET("/clientePorId/{idCliente}")
    Call<Cliente> clientePorId(
            @Path("idCliente")
                    int idCliente);


}
