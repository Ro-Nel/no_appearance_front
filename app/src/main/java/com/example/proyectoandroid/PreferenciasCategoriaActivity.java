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
import com.example.proyectoandroid.model.ProfileSubcategory;
import com.example.proyectoandroid.model.SubCategory;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class PreferenciasCategoriaActivity extends AppCompatActivity {

    Apis apis;
    List<Category> categoryList = new ArrayList<>();

    ListView listView;
    Button btSubCategorias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias_categoria);

        listView = (ListView) findViewById(R.id.listView);
        listarCategories();
        btSubCategorias = (Button) findViewById(R.id.btSubCategorias);
        btSubCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), PreferenciasSubcategories.class);
                startActivityForResult(intent, 200);
            }

        });
    }



    public void listarCategories(){
        Call<List<Category>> call = apis.getCategoriesService().listarcategorias();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categoryList = response.body();
                listView.setAdapter( new CategoriesAdapter(PreferenciasCategoriaActivity.this, R.layout.activity_preferencias_categoria, categoryList));
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });
    }


}