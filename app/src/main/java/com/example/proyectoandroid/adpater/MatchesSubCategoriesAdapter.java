package com.example.proyectoandroid.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.proyectoandroid.PreferenciasSubcategoriasActivity;
import com.example.proyectoandroid.R;
import com.example.proyectoandroid.model.MatchSubcategoria;
import com.example.proyectoandroid.model.SubCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MatchesSubCategoriesAdapter extends ArrayAdapter <MatchSubcategoria> {

    private Context context;
    private List<MatchSubcategoria> matchSubcategoriaList;


    public MatchesSubCategoriesAdapter(@NonNull Context context, int resource, @NonNull List<MatchSubcategoria> objects) {
        super(context, resource, objects);
        this.context = context;
        this.matchSubcategoriaList = objects;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = layoutInflater.inflate(R.layout.matches_detalle_content, parent, false);
        ImageView foto = (ImageView) v.findViewById(R.id.fotom);
        TextView name = (TextView) v.findViewById(R.id.namem);
        name.setText(matchSubcategoriaList.get(position).getSubcategoria());
        Picasso.get().load(matchSubcategoriaList.get(position).getFoto())
                .resize(100,100)
                .centerCrop()
                .into(foto);

        return v;

    }


}
