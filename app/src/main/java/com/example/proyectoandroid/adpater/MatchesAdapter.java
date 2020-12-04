package com.example.proyectoandroid.adpater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.proyectoandroid.*;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.Match;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MatchesAdapter extends ArrayAdapter <Match> {

    private Context context;
    private List<Match> mathList;


    public MatchesAdapter(@NonNull Context context, int resource, @NonNull List<Match> objects) {
        super(context, resource, objects);
        this.context = context;
        this.mathList = new ArrayList<>();
        mathList.addAll(objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = layoutInflater.inflate(R.layout.matches_list_content, parent, false);
        TextView twPersona = (TextView) v.findViewById(R.id.twPersona);
        twPersona.setText(mathList.get(position).getNameCliente());
        twPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MatchDetalleActivity.class);
                intent.putExtra("idMacth",String.valueOf(mathList.get(position).getIdMatch()));
                if(mathList.get(position).getIdCliente1() == LoginActivity.IDCLIENTE)
                    intent.putExtra("idOtroCliente",String.valueOf(mathList.get(position).getIdCliente2()));
                else
                    intent.putExtra("idOtroCliente",String.valueOf(mathList.get(position).getIdCliente1()));
                context.startActivity(intent);
            }
        });
        return v;
    }


}
