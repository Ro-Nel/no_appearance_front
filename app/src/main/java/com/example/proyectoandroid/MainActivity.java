package com.example.proyectoandroid;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.adpater.CategoriesAdapter;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Apis categoriesService;
    Category category;

    Button btRegistro;
    Button btLogin;
    Button btPreferenciasCategoria;
    Button btMatchesListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //insertarCategory();

        btRegistro = (Button) findViewById(R.id.registro);
        btLogin = (Button) findViewById(R.id.login);
        btPreferenciasCategoria = (Button) findViewById(R.id.btPreferenciasCategoria);
        btMatchesListar = (Button) findViewById(R.id.btMatchesListar);

        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), RegistroActivity.class);
                startActivityForResult(intent, 200);
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), LoginActivity.class);
                startActivityForResult(intent, 200);
            }
        });
        btPreferenciasCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), PreferenciasCategoriaActivity.class);
                startActivityForResult(intent, 200);
            }
        });
        btPreferenciasCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), PreferenciasCategoriaActivity.class);
                startActivityForResult(intent, 200);
            }
        });
        btMatchesListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MatchesActivity.class);
                startActivityForResult(intent, 200);
            }
        });


    }

    public void insertarCategory(){
        Category categoryprueba = new Category("Prueba");
        Call<Category> call = categoriesService.getCategoriesService().insertcategory(categoryprueba);
        call.enqueue(new Callback<Category>() {

            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                category = response.body();
                Log.i( "Category............................ ","ll");
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });
    }


}