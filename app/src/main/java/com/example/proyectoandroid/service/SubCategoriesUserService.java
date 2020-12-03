package com.example.proyectoandroid.service;

import com.example.proyectoandroid.model.ProfileSubcategory;
import com.example.proyectoandroid.model.SubCategory;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

import java.util.List;

public interface SubCategoriesUserService {



    @GET("/v1/category/postProfileSubCategory")
    Call<SubCategory> postProfileSubCategory(
            @Body ProfileSubcategory profileSubcategory
    );


}
