package com.example.proyectoandroid;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.adpater.CategoriesAdapter;
import com.example.proyectoandroid.adpater.MatchesSubCategoriesAdapter;
import com.example.proyectoandroid.adpater.*;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.MatchSubcategoria;
import com.example.proyectoandroid.model.Mensaje;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MensajeriaActivity extends AppCompatActivity {

    Apis apis;
    List<Mensaje> mensajeList = new ArrayList<>();
    MensajesAdapter mensajesAdapter = null;
    ListView listView;
    Button btEnviarMensaje;
    EditText mensajeTexto;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajeria);
        final int idChat= Integer.parseInt(getIntent().getExtras().getString("idChat"));

        listView = (ListView) findViewById(R.id.listViewMensajes);
        btEnviarMensaje = (Button) findViewById(R.id.btEnviarMensaje);
        mensajeTexto = (EditText) findViewById(R.id.mensajeTexto);
        listarMensajes(idChat);
        btEnviarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMensaje(idChat);
            }
        });

        }

    private void enviarMensaje(int idChat) {
        String mensajeg = mensajeTexto.getText().toString();
        Mensaje mensaje = new Mensaje(mensajeg, idChat);
        Call<String> call = apis.getChatService().mensajeschatguardar(mensaje);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext()," Mensaje enviado ",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });

    }

    private void listarMensajes(int idChat) {
        Call<List<Mensaje>> call = apis.getChatService().mensajesChat(idChat);
        call.enqueue(new Callback<List<Mensaje>>() {
            @Override
            public void onResponse(Call<List<Mensaje>> call, Response<List<Mensaje>> response) {
                mensajeList = response.body();
                mensajesAdapter =new MensajesAdapter(MensajeriaActivity.this, R.layout.activity_mensajeria, mensajeList);
                listView.setAdapter(mensajesAdapter);
            }

            @Override
            public void onFailure(Call<List<Mensaje>> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });

    }





}