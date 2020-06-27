package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.Adaptadores.listview_receta;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades.Nombre;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

import java.util.ArrayList;
import java.util.List;

public class Lista_recetaActivity extends AppCompatActivity {
    Integer [] a= new Integer[7];
    ListView lista_receta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_receta);

        lista_receta=(ListView)findViewById(R.id.listview_lista_receta);
        this.cura();
        this.LoadListView();
    }


    private void LoadListView() {

        RecetasBDHelper admin = new RecetasBDHelper(this, "users", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        List<Nombre> nom = new ArrayList<Nombre>();

        Cursor cursor = BaseDeDatos.rawQuery
                ("select name,description from recipes", null);

        if (cursor.moveToFirst()) {

            do {

                Nombre name = new Nombre(
                        cursor.getString(0),
                        cursor.getString(1)
                );

                nom.add(name);
            } while (cursor.moveToNext());
        }

        listview_receta adapter = new listview_receta(this, nom);
        lista_receta.setAdapter(adapter);

        lista_receta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(view.getContext(), MostrarActivity.class);
                String tipoo=getIntent().getStringExtra("type");
                int x = a[position];
                i.putExtra("RECETA", x);
                i.putExtra("TIPO", tipoo);
                startActivity(i);
            }
        });
    }

    public void cura() {

        RecetasBDHelper admin = new RecetasBDHelper(this, "users", null, R.integer.DBVersion);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();
        String[] campos = new String[]{"id_recipes"};

        Cursor c = BaseDeDatos.query("recipes", campos, null, null, null, null, null);
        int p = 0;
        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                a[p] = c.getInt(0);
                p++;
            } while (c.moveToNext());
        }
    }

}
