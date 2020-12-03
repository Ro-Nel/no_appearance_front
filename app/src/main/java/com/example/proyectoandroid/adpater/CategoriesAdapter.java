package com.example.proyectoandroid.adpater;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectoandroid.PreferenciasCategoriaActivity;
import com.example.proyectoandroid.R;
import com.example.proyectoandroid.model.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends ArrayAdapter <Category> {

    private Context context;
    private List<Category> categoryList;


    public CategoriesAdapter(@NonNull Context context, int resource, @NonNull List<Category> objects) {
        super(context, resource, objects);
        this.context = context;
        this.categoryList = new ArrayList<>();
        categoryList.addAll(objects);
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = layoutInflater.inflate(R.layout.category_list_content, parent, false);
        CheckBox checkBoxCategory = (CheckBox) v.findViewById(R.id.checkBoxCategory);
        ImageView foto = (ImageView) v.findViewById(R.id.foto);
        TextView name = (TextView) v.findViewById(R.id.name);

        checkBoxCategory.setOnCheckedChangeListener((PreferenciasCategoriaActivity)context);

        Category category = categoryList.get(position);
        Picasso.get().load(categoryList.get(position).getFoto())
                .resize(100,100)
                .centerCrop()
                .into(foto);
        name.setText(String.format("Categoria nombre:%s", categoryList.get(position).getCategoria()));

        return v;
    }
}
