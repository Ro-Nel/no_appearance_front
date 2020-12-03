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
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.SubCategory;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class PreferenciasSubcategoriasActivity extends AppCompatActivity {

    Apis apis;
    List<SubCategory> subcategoryList = new ArrayList<>();

    ListView listView;
    Button btSubCategorias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias_subcategorias);

        //listView = (ListView) findViewById(R.id.listViewSC);
        //int idCategoria= Integer.parseInt(getIntent().getExtras().getString("idCategoria"));
        //listarSubCategories(idCategoria);
        //btSubCategorias = (Button) findViewById(R.id.btRegistrarSubCategorias);

    }
/*
    public void listarSubCategories(int idCategoria){
        Call<List<SubCategory>> call = apis.getSubCategoriesService(idCategoria).getSubCategories();
        call.enqueue(new Callback<List<SubCategory>>() {
            @Override
            public void onResponse(Call<List<SubCategory>> call, Response<List<SubCategory>> response) {
                subcategoryList = response.body();
                listView.setAdapter( new SubCategoriesAdapter(PreferenciasSubcategoriasActivity.this, R.layout.activity_preferencias_categoria, subcategoryList));
            }

            @Override
            public void onFailure(Call<List<SubCategory>> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });
    }
*/
}