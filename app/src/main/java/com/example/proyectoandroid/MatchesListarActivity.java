package com.example.proyectoandroid;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.util.Apis;

import java.util.ArrayList;
import java.util.List;

public class MatchesListarActivity extends AppCompatActivity {



    Apis apis;
    List<Category> categoryList = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches_listar);
    }
}