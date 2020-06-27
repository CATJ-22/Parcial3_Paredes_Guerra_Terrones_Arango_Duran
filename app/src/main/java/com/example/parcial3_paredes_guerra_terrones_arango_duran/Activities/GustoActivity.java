package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class GustoActivity extends AppCompatActivity {

    String nom="",tipo="";
    String gustoo="", iguall="";
    int id_usuario=0, id_receta=0;
    Spinner spinner1, spinner2;
    TextView nombre, descrip, restaurante, ingredientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gusto);
        tipo=getIntent().getStringExtra("type");
        this.InicializarControles();
    }

    private void InicializarControles() {

        nombre = (TextView) findViewById(R.id.txt_name_gusto);
        descrip = (TextView) findViewById(R.id.txt_descri_gusto);
        ingredientes = (TextView) findViewById(R.id.txt_ingre_gusto);
        restaurante = (TextView) findViewById(R.id.txt_resta_gusto);

        spinner1=(Spinner)findViewById(R.id.spinner);
        spinner2=(Spinner)findViewById(R.id.spinner2);

        this.AgregarFAV();
    }

    private void AgregarFAV() {

        int pos = getIntent().getIntExtra("Receta", 0);

        RecetasBDHelper admin = new RecetasBDHelper(this, "users", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor cursor = BaseDeDatos.rawQuery
                ("select id_recipes, name, description, ingredients, restaurant from recipes where id_recipes='" + pos + "'", null);

        if (cursor.moveToFirst()) {

            id_receta=cursor.getInt(0);
            nombre.setText(cursor.getString(1));
            descrip.setText(cursor.getString(2));
            restaurante.setText(cursor.getString(3));
            ingredientes.setText(cursor.getString(4));


        }

        nom=cursor.getString(1);

        String[] gusto= {"ME GUSTA", "NO ME GUSTA"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, gusto);
        spinner1.setAdapter(adaptador);

        String seleccion1 = spinner1.getSelectedItem().toString();

        if (seleccion1.equals("ME GUSTA")) {
            gustoo="SI";

        }else{
            gustoo="NO";
        }

        String[] igual= {"ES IGUAL A LA ORIGINAL", "NO ES IGUAL A LA ORIGINAL"};
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, igual);
        spinner2.setAdapter(adaptador2);

        String seleccion2 = spinner2.getSelectedItem().toString();

        if (seleccion1.equals("ES IGUAL A LA ORIGINAL")) {
            iguall="SI";
        }else{
            iguall="NO";
        }
    }

    public void Guardar(View view){

        RecetasBDHelper admin = new RecetasBDHelper(this, "users", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(BaseDeDatos!=null) {
            ContentValues values = new ContentValues();

            values.put("name", nom);
            values.put("id_recipes", id_receta);
            values.put("like_recipe", "GUSTO: "+gustoo);
            values.put("dislike_recipe", "IGUAL A: "+iguall);

            BaseDeDatos.insert("fav_recipe", null, values);
            BaseDeDatos.close();

            Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, MenuActivity.class);
            i.putExtra("type", tipo);
            i.putExtra("GUSTO", gustoo);
            i.putExtra("IGUAL", iguall);
            startActivity(i);
        }

    }
}