package com.example.angel.viewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Angel on 09/03/2015.
 */
public class MyAdapter extends BaseAdapter {
    List<Celda> celdas = new ArrayList<>();
    HashMap<Integer, Integer> viewTypesMap = new HashMap<>();

    public MyAdapter(List<Celda> celdas) {
        this.celdas = celdas;
        analyzeViewTypes();
    }

    private void analyzeViewTypes() {
        for (Celda celda : celdas)
            if (!viewTypesMap.containsKey(celda.layoutId()))
                viewTypesMap.put(celda.layoutId(), viewTypesMap.size());
    }

    @Override
    public int getCount() {
        return celdas.size();
    }

    @Override
    public Object getItem(int position) {
        return celdas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Celda celda = celdas.get(position);

        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(celda.layoutId(), parent, false);

        celda.adaptView(convertView);

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypesMap.get(celdas.get(position).layoutId());
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }
}
