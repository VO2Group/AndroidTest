package com.vo2group.zoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vo2group.zoo.model.Category;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {

    private final LayoutInflater mInflater;

    private final int mResource;

    public CategoryAdapter(Context context, List<Category> objects) {
        super(context, R.layout.layout_category, objects);

        mInflater = LayoutInflater.from(context);
        mResource = R.layout.layout_category;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(mInflater, position, convertView, parent, mResource);
    }

    private View createViewFromResource(LayoutInflater inflater, int position, View convertView, ViewGroup parent, int resource) {

        View view;

        if (convertView == null) {
            view = inflater.inflate(resource, parent, false);
        } else {
            view = convertView;
        }

        TextView textView = (TextView) view.findViewById(R.id.Name);

        Category item = getItem(position);

        textView.setText(item.getName());

        return view;
    }
}
