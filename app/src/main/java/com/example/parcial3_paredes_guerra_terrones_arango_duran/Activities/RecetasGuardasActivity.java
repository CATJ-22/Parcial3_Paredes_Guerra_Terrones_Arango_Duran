package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.Adaptadores.listview_adapter;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades.Recipes;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

import java.util.ArrayList;
import java.util.List;

public class RecetasGuardasActivity extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas_guardas);

        this.InicializarControles();
    }

    private void InicializarControles() {

        lista=(ListView)findViewById(R.id.listview);

        this.LoadListView();
    }

    private void LoadListView() {

        List<Recipes> receta = new ArrayList<Recipes>();


       // receta.add(new Recipes("Receta 1", "", "", "", "", "", ""));

        listview_adapter adapter= new listview_adapter(getApplicationContext(), receta);
        lista.setAdapter(adapter);


        //hola

    }

}