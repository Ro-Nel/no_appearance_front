package com.example.proyectoandroid.adpater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.proyectoandroid.LoginActivity;
import com.example.proyectoandroid.MatchDetalleActivity;
import com.example.proyectoandroid.MensajeriaActivity;
import com.example.proyectoandroid.R;
import com.example.proyectoandroid.model.Chat;
import com.example.proyectoandroid.model.Match;

import java.util.ArrayList;
import java.util.List;

public class ChatsAdapter extends ArrayAdapter <Chat> {

    private Context context;
    private List<Chat> chatList;


    public ChatsAdapter(@NonNull Context context, int resource, @NonNull List<Chat> objects) {
        super(context, resource, objects);
        this.context = context;
        this.chatList = new ArrayList<>();
        chatList.addAll(objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = layoutInflater.inflate(R.layout.chats_list_content, parent, false);
        TextView twPersona = (TextView) v.findViewById(R.id.twPersonaChat);
        twPersona.setText(chatList.get(position).getNameCliente());
        twPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MensajeriaActivity.class);
                intent.putExtra("idChat",String.valueOf(chatList.get(position).getIdChat()));
                context.startActivity(intent);
            }
        });
        return v;
    }


}
