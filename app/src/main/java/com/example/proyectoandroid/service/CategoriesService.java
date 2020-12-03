package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.Category;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import java.util.List;

public interface CategoriesService {

    @GET("listarcategorias")
    Call<List<Category>> listarcategorias();

    @POST("/v1/category")
    Call<Category> insertcategory(
            @Body Category category
    );

}
