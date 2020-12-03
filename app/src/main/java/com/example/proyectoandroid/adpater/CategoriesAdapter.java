package com.example.proyectoandroid.adpater;

import android.content.Context;
import android.net.Uri;
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
import com.example.proyectoandroid.R;
import com.example.proyectoandroid.model.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends ArrayAdapter <Category> {

    private Context context;
    private List<Category> categoryList;
    public  static  List<Integer> categoryChoseeList = new ArrayList<>();


    public CategoriesAdapter(@NonNull Context context, int resource, @NonNull List<Category> objects) {
        super(context, resource, objects);
        this.context = context;
        this.categoryList = objects;
    }



    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.category_list_content, parent, false);
        CheckBox checkBoxCategory = (CheckBox) rowView.findViewById(R.id.checkBoxCategory);

        ImageView foto = (ImageView) rowView.findViewById(R.id.foto);
        TextView name = (TextView) rowView.findViewById(R.id.name);
        Picasso.get().load(categoryList.get(position).getFoto())
                .resize(100,100)
                .centerCrop()
                .into(foto);
        name.setText(String.format("Categoria nombre:%s", categoryList.get(position).getCategoria()));

        checkBoxCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryChoseeList.add(categoryList.get(position).getIdCategoria());
            }
        });

        return rowView;
    }
}
