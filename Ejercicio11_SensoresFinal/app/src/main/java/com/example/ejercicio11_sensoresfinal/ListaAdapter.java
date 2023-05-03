package com.example.ejercicio11_sensoresfinal;

import java.util.ArrayList;
import android.content.Context;
import android.view.*;
import android.widget.BaseAdapter;

public abstract class ListaAdapter extends BaseAdapter{

    private ArrayList<?> al;
    private int R_layout_IdView;
    private Context c;

    public ListaAdapter(Context c, int R_layout_IdView, ArrayList<?> al){
        super();
        this.c = c;
        this.al = al;
        this.R_layout_IdView = R_layout_IdView;
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater vi = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R_layout_IdView,null);
        }
        onEntrada(al.get(position), convertView);
        return convertView;
    }

    public abstract void onEntrada(Object o, View v);
}
