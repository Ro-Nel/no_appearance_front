package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.ClienteSubcategoria;
import com.example.proyectoandroid.model.ProfileSubcategory;
import com.example.proyectoandroid.model.SubCategory;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface SubCategoriesUserService {



    @POST("/clientesubcategoria/guardar")
    Call<String> clientesubcategoriaGuardar(
            @Body ClienteSubcategoria clienteSubcategoria
    );


}
