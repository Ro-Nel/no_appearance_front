package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.Match;
import com.example.proyectoandroid.model.MatchSubcategoria;
import com.example.proyectoandroid.model.SubCategory;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface MatchService {

    @GET("/listarmatches/{idCliente}")
    Call<List<Match>> listarmatchesIdCliente(
            @Path("idCliente")
                    int idCliente);

    @GET("/matchdetalle/{idCliente1}/{idCliente2}")
    Call<List<MatchSubcategoria>> matchdetalleClientes(
            @Path("idCliente1")
                    int idCliente1,
            @Path("idCliente2")
                int idCliente2);
}
