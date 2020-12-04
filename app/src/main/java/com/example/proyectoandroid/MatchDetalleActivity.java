package com.example.proyectoandroid;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.adpater.CategoriesAdapter;
import com.example.proyectoandroid.adpater.MatchesAdapter;
import com.example.proyectoandroid.adpater.MatchesSubCategoriesAdapter;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.Cliente;
import com.example.proyectoandroid.model.Match;
import com.example.proyectoandroid.model.MatchSubcategoria;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MatchDetalleActivity extends AppCompatActivity {
    Apis apis;
    Category category;

    TextView NombreApellido;
    ListView listViewSCM;
    Button chatRegistro;

    List<MatchSubcategoria> matchSubcategoriaList = new ArrayList<>();
    Cliente cliente;
    MatchesSubCategoriesAdapter matchesSubCategoriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detalle);
        final int idMacth= Integer.parseInt(getIntent().getExtras().getString("idMacth"));
        int idOtroCliente= Integer.parseInt(getIntent().getExtras().getString("idOtroCliente"));
        listViewSCM = (ListView) findViewById(R.id.listViewSCM);
        NombreApellido = (TextView) findViewById(R.id.NombreApellido);
        vercliente(idMacth,idOtroCliente);
        listarMatchSubcategorias(idOtroCliente);
        chatRegistro = (Button) findViewById(R.id.chatRegistro);
        chatRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarchat(idMacth);
            }
        });
    }

    private void guardarchat(int idMacth) {
        Call<String> call = apis.getChatService().agregarChatPorIdMatch(idMacth);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i( "agragado","agregado");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });
    }

    private void listarMatchSubcategorias(int idOtroCliente) {
        Call<List<MatchSubcategoria>> call = apis.getMatchService().matchdetalleClientes(LoginActivity.IDCLIENTE, idOtroCliente);
        call.enqueue(new Callback<List<MatchSubcategoria>>() {
            @Override
            public void onResponse(Call<List<MatchSubcategoria>> call, Response<List<MatchSubcategoria>> response) {
                matchSubcategoriaList = response.body();
                matchesSubCategoriesAdapter =new MatchesSubCategoriesAdapter(MatchDetalleActivity.this, R.layout.activity_match_detalle, matchSubcategoriaList);
                listViewSCM.setAdapter(matchesSubCategoriesAdapter);
            }

            @Override
            public void onFailure(Call<List<MatchSubcategoria>> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });

    }

    private void vercliente(int idMacth,int idOtroCliente) {
        Call<Cliente> call = apis.clienteService().clientePorId(idOtroCliente);
        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                cliente = response.body();
                NombreApellido.setText(cliente.getNombre() +" "+cliente.getApellido());
            }
            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });
    }


}