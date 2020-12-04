package com.example.proyectoandroid.adpater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.proyectoandroid.MensajeriaActivity;
import com.example.proyectoandroid.R;
import com.example.proyectoandroid.model.Chat;
import com.example.proyectoandroid.model.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class MensajesAdapter extends ArrayAdapter <Mensaje> {

    private Context context;
    private List<Mensaje> mensajeList;


    public MensajesAdapter(@NonNull Context context, int resource, @NonNull List<Mensaje> objects) {
        super(context, resource, objects);
        this.context = context;
        this.mensajeList = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = layoutInflater.inflate(R.layout.chats_list_content, parent, false);
        TextView twPersona = (TextView) v.findViewById(R.id.twPersonaChat);
        twPersona.setText(mensajeList.get(position).getMensaje());

        return v;
    }


}
