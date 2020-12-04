package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface ChatService {

    @GET("/agregarChatPorIdMatch/{idMacth}")
    Call<String> agregarChatPorIdMatch(
            @Path("idMacth")
                    int idMacth);

    @GET("/listarchats/{idCliente}")
    Call<List<Chat>> listarChatsPorIdCliente(
            @Path("idCliente")
                    int idCliente);

    @GET("/mensajeschat/{idChatEntity}")
    Call<List<Mensaje>> mensajesChat(
            @Path("idChatEntity")
                    int idChatEntity);

    @POST("mensajeschatguardar")
    Call<String> mensajeschatguardar(
            @Body Mensaje mensaje
    );

}