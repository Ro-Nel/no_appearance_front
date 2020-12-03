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
import com.example.proyectoandroid.PreferenciasCategoriaActivity;
import com.example.proyectoandroid.PreferenciasSubcategoriasActivity;
import com.example.proyectoandroid.R;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.SubCategory;
import com.squareup.picasso.Picasso;
import retrofit2.Callback;

import java.util.ArrayList;
import java.util.List;

public class SubCategoriesAdapter extends ArrayAdapter <SubCategory> {

    private Context context;
    private List<SubCategory> categoryList;
    public  static  List<Integer> subcategoryChoseeList = new ArrayList<>();

    public SubCategoriesAdapter(@NonNull Context context, int resource, @NonNull List<SubCategory> objects) {
        super(context, resource, objects);
        this.context = context;
        this.categoryList = objects;
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
        name.setText(String.format("Nombre:%s", categoryList.get(position).getSubcategoria()));

        checkBoxCategory.setOnCheckedChangeListener((PreferenciasSubcategoriasActivity)context);
        SubCategory subCategory = categoryList.get(position);
        Picasso.get().load(categoryList.get(position).getFoto())
                .resize(100,100)
                .centerCrop()
                .into(foto);
        return v;

    }



}
