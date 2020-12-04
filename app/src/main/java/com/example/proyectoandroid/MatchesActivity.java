package com.example.proyectoandroid;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.adpater.CategoriesAdapter;
import com.example.proyectoandroid.adpater.MatchesAdapter;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.Match;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MatchesActivity extends AppCompatActivity{


    Apis apis;
    List<Match> matchList = new ArrayList<>();
    MatchesAdapter matchesAdapter = null;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);
        listView = (ListView) findViewById(R.id.listViewMacth);
        listarMatches();
    }

    private void listarMatches() {
        Call<List<Match>> call = apis.getMatchService().listarmatchesIdCliente(LoginActivity.IDCLIENTE);
        call.enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                matchList = response.body();
                matchesAdapter =new MatchesAdapter(MatchesActivity.this, R.layout.activity_matches, matchList);
                listView.setAdapter(matchesAdapter);
            }
            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });
    }



}