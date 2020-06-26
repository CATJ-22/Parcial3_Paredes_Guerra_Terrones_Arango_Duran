package com.example.parcial3_paredes_guerra_terrones_arango_duran.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades.Nombre2;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;
import java.util.ArrayList;
import java.util.List;

public class listview_adapter2 extends ArrayAdapter<Nombre2> {


    private List<Nombre2> opciones = new ArrayList<>();

    public listview_adapter2(Context context, List<Nombre2> datos) {
        super(context, R.layout.listview_list2, datos);

        opciones = datos;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_list2, null);

        TextView nom = (TextView)item.findViewById(R.id.txt_name_guarda);
        nom.setText(opciones.get(position).getName());

        TextView like = (TextView)item.findViewById(R.id.txt_gusto_guarda);
        like.setText(opciones.get(position).getLike());

        TextView dislike = (TextView)item.findViewById(R.id.txt_igual_guarda);
        dislike.setText(opciones.get(position).getDislike());

        return (item);
    }
}