package com.example.parcial3_paredes_guerra_terrones_arango_duran.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades.Recipes;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

import java.util.ArrayList;
import java.util.List;

public class listview_adapter extends ArrayAdapter<Recipes> {


    private List<Recipes> opciones = new ArrayList<>();

    public listview_adapter(Context context, List<Recipes> datos) {
        super(context, R.layout.listview_list, datos);

        opciones = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_list, null);

        TextView nombre = (TextView)item.findViewById(R.id.txt_nombreReceta);
        nombre.setText(opciones.get(position).getName());

        return (item);
    }
}