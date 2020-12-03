package com.example.proyectoandroid.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.proyectoandroid.R;
import com.example.proyectoandroid.model.Category;
import com.example.proyectoandroid.model.SubCategory;
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.category_list_content, parent, false);
        CheckBox checkBoxCategory = (CheckBox) rowView.findViewById(R.id.checkBoxCategory);
        TextView id = (TextView) rowView.findViewById(R.id.id);
        TextView name = (TextView) rowView.findViewById(R.id.name);
        id.setText(String.format("Categotia id:%s", categoryList.get(position).getCategoryId()));
        name.setText(String.format("Categoria nombre:%s", categoryList.get(position).getName()));

        checkBoxCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subcategoryChoseeList.add(categoryList.get(position).getCategoryId());
            }
        });

        return rowView;
    }
}
