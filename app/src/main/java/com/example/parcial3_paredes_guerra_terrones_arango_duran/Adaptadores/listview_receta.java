package com.example.parcial3_paredes_guerra_terrones_arango_duran.Adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades.Nombre;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades.Recipes;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

import java.util.ArrayList;
import java.util.List;

public class listview_receta extends ArrayAdapter<Nombre> {

    private List<Nombre> opciones = new ArrayList<Nombre>();

    public listview_receta(Context context, List<Nombre> datos) {
        super(context, R.layout.listview_recetas, datos);

        opciones = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_recetas, null);

        TextView titulo = (TextView)item.findViewById(R.id.txt_titulo);
        titulo.setText(opciones.get(position).getNombre());

        TextView descripcion = (TextView)item.findViewById(R.id.txt_description);
        descripcion.setText(opciones.get(position).getDescripcion());

        return (item);
    }
}
