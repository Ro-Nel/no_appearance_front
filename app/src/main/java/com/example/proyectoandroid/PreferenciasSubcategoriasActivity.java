package com.example.proyectoandroid;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.adpater.CategoriesAdapter;
import com.example.proyectoandroid.adpater.SubCategoriesAdapter;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.ClienteSubcategoria;
import com.example.proyectoandroid.model.SubCategory;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class PreferenciasSubcategoriasActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Apis apis;
    List<SubCategory> subcategoryList = new ArrayList<>();
    SubCategoriesAdapter subcategoriesAdapter = null;
    ListView listView;
    Button btCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias_subcategorias);
        listView = (ListView) findViewById(R.id.listViewSC);
        String SidCategoria= getIntent().getExtras().getString("idCategoria");
        int idCategoria= Integer.parseInt(getIntent().getExtras().getString("idCategoria"));
        listarSubCategories(idCategoria);
        btCategorias = (Button) findViewById(R.id.btCategorias);
        btCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), PreferenciasCategoriaActivity.class);
                startActivityForResult(intent, 200);
                finish();
            }
        });

    }

    public void listarSubCategories(int idCategoria){
        Call<List<SubCategory>> call = apis.getSubCategoriesService().getSubCategories(idCategoria);
        call.enqueue(new Callback<List<SubCategory>>() {
            @Override
            public void onResponse(Call<List<SubCategory>> call, Response<List<SubCategory>> response) {
                subcategoryList = response.body();
                subcategoriesAdapter =new SubCategoriesAdapter(PreferenciasSubcategoriasActivity.this, R.layout.activity_preferencias_categoria, subcategoryList);
                listView.setAdapter(subcategoriesAdapter);
            }

            @Override
            public void onFailure(Call<List<SubCategory>> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int position = listView.getPositionForView(buttonView);
        int idSubcategory =subcategoryList.get(position).getIdSubcategoria();
        guardarClientesubcategory(LoginActivity.IDCLIENTE, idSubcategory);
    }

    private void guardarClientesubcategory(int idcliente, int idSubcategory) {
        ClienteSubcategoria clienteSubcategoria = new ClienteSubcategoria(idcliente,idSubcategory);
        Call<String> call = apis.getSubCategoriesUserService().clientesubcategoriaGuardar(clienteSubcategoria);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext(), "Subcategoria Registrada",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });
    }
}