package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.Chat;
import com.example.proyectoandroid.model.Match;
import com.example.proyectoandroid.model.MatchSubcategoria;
import retrofit2.Call;
import retrofit2.http.GET;
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

}