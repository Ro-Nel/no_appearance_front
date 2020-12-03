package com.example.proyectoandroid;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.adpater.CategoriesAdapter;
import com.example.proyectoandroid.adpater.SubCategoriesAdapter;
import com.example.proyectoandroid.model.ProfileSubcategory;
import com.example.proyectoandroid.model.SubCategory;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

class PreferenciasSubcategories extends AppCompatActivity {

    Apis apis;
    Button btSubCategorias;
    ListView listView;
    List<SubCategory> subCategoryList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias_subcategories);
        subCategorias();
        listView = (ListView) findViewById(R.id.listView);
        btSubCategorias = (Button) findViewById(R.id.btSubCategorias);
        btSubCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSubCategories();
                Log.i(" sub Category............................ ", "creo");
            }

        });
    }



    // toma datos de todas las subcategorias
    public void subCategorias() {
        List<Integer> categoryChoseeList = new ArrayList<>();
        categoryChoseeList = CategoriesAdapter.categoryChoseeList;
        for ( Integer c:categoryChoseeList ) {
            List<SubCategory> subCategoryListTemp = listarSubCategories(c);
            subCategoryList.add((SubCategory) subCategoryListTemp);
        }

    }

    private List<SubCategory> listarSubCategories(Integer c) {
        List<SubCategory> subCategoryListTemp = new ArrayList<>();

        Call<List<SubCategory>> call = apis.getSubCategoriesService().getSubCategories(c);
        call.enqueue(new Callback<List<SubCategory>>() {
            @Override
            public void onResponse(Call<List<SubCategory>> call, Response<List<SubCategory>> response) {
                subCategoryList = response.body();
                listView.setAdapter( new SubCategoriesAdapter (PreferenciasSubcategories.this, R.layout.activity_preferencias_categoria, subCategoryList));
            }

            @Override
            public void onFailure(Call<List<SubCategory>> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });

        return subCategoryListTemp;
    }

    private void addSubCategories() {

        List<Integer> subCategoryChoseeList = new ArrayList<>();
        subCategoryChoseeList = SubCategoriesAdapter.subcategoryChoseeList;

        for ( Integer sc:subCategoryChoseeList ) {
            ProfileSubcategory profileSubcategory = new ProfileSubcategory(0,sc); //TODO arreglar el id del perfil
            Call<SubCategory> call = apis.getSubCategoriesUserService().postProfileSubCategory(profileSubcategory);
            call.enqueue(new Callback<SubCategory>() {
                @Override
                public void onResponse(Call<SubCategory> call, Response<SubCategory> response) {
                    Log.i(" sub Category............................ ", "creo");
                }

                @Override
                public void onFailure(Call<SubCategory> call, Throwable t) {
                    Log.e("Error ", t.getMessage());
                }
            });
        }
    }
}