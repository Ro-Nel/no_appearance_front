package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.SubCategory;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface SubCategoriesService {

    @GET("/v1/category/subcategories")
    Call<List<SubCategory>> getSubCategories(
            @Body Integer categoryId
    );


}
