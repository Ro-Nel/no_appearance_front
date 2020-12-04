package com.example.proyectoandroid;

import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.adpater.ChatsAdapter;
import com.example.proyectoandroid.adpater.MatchesAdapter;
import com.example.proyectoandroid.model.Chat;
import com.example.proyectoandroid.model.Match;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class ChatsActivity extends AppCompatActivity {

    Apis apis;
    List<Chat> chatList = new ArrayList<>();
    ChatsAdapter chatsAdapter = null;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        listView = (ListView) findViewById(R.id.listViewMacth);
        listarMatches();
    }

    private void listarMatches() {
        Call<List<Chat>> call = apis.getChatService().listarChatsPorIdCliente(LoginActivity.IDCLIENTE);
        call.enqueue(new Callback<List<Chat>>() {
            @Override
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
                chatList = response.body();
                System.out.println(chatList.get(0).getNameCliente());
                chatsAdapter =new ChatsAdapter(ChatsActivity.this, R.layout.activity_matches, chatList);
                listView.setAdapter(chatsAdapter);
            }
            @Override
            public void onFailure(Call<List<Chat>> call, Throwable t) {
                Log.e( "Error ",t.getMessage());
            }
        });
    }



}