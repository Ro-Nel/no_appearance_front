package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.SubCategory;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface SubCategoriesService {

    @GET("/listarsubcategorias/{idCategoria}")
    Call<List<SubCategory>> getSubCategories(
            @Path("idCategoria")
            int idCategoria);
}
