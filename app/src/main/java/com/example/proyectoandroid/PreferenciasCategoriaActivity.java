package com.example.proyectoandroid;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.solver.state.State;
import com.example.proyectoandroid.adpater.CategoriesAdapter;
import com.example.proyectoandroid.adpater.SubCategoriesAdapter;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.ProfileSubcategory;
import com.example.proyectoandroid.model.SubCategory;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class PreferenciasCategoriaActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Apis apis;
    List<Category> categoryList = new ArrayList<>();
    CategoriesAdapter categoriesAdapter = null;
    ListView listView;
    Button btSubCategorias;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias_categoria);

        listView = (ListView) findViewById(R.id.listView);
        listarCategories();
        btSubCategorias = (Button) findViewById(R.id.btSubCategorias);



    }


    public void listarCategories(){
        Call<List<Category>> call = apis.getCategoriesService().listarcategorias();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categoryList = response.body();
                categoriesAdapter =new CategoriesAdapter(PreferenciasCategoriaActivity.this, R.layout.activity_preferencias_categoria, categoryList);
                listView.setAdapter(categoriesAdapter);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int position = listView.getPositionForView(buttonView);
        int idCategoria =categoryList.get(position).getIdCategoria();
        System.out.println(idCategoria);
        Intent intent = new Intent (getApplicationContext(), PreferenciasSubcategoriasActivity.class);
        intent.putExtra("idCategoria",String.valueOf(idCategoria));
        startActivityForResult(intent, 200);
        finish();

    }
}