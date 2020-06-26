package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class MostrarActivity extends AppCompatActivity {

    Button fav, delete;
    TextView nombre, descrip, restaurante, comentario, imagen, ingredientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        this.InicializarControles();

        String tipo=getIntent().getStringExtra("TIPO");

        if(tipo.equalsIgnoreCase("administrador")){
            fav.setVisibility(View.INVISIBLE);
        }else{
            delete.setVisibility(View.INVISIBLE);
        }
    }

    private void InicializarControles() {

        fav = (Button) findViewById(R.id.boton_agregar);
        delete = (Button) findViewById(R.id.boton_eliminar);

        nombre = (TextView) findViewById(R.id.txt_name_receta);
        descrip = (TextView) findViewById(R.id.txt_descri_receta);
        restaurante = (TextView) findViewById(R.id.txt_resta_receta);
        comentario = (TextView) findViewById(R.id.txt_come_receta);
        imagen = (TextView) findViewById(R.id.txt_imagen_receta);
        ingredientes = (TextView) findViewById(R.id.txt_ingre_receta);

        this.MostrarReceta();

    }

    private void MostrarReceta() {

        int pos = getIntent().getIntExtra("RECETA", 0);

        RecetasBDHelper admin = new RecetasBDHelper(this, "users", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor cursor = BaseDeDatos.rawQuery
                ("select name, description, ingredients, restaurant, comments, image from recipes where id_recipes='" + pos + "'", null);

        if (cursor.moveToFirst()) {

            nombre.setText(cursor.getString(0));
            descrip.setText(cursor.getString(1));
            restaurante.setText(cursor.getString(2));
            comentario.setText(cursor.getString(3));
            imagen.setText(cursor.getString(4));
            ingredientes.setText(cursor.getString(5));

        }
    }

    public void AgregarFav(View view){
        Intent i = new Intent(view.getContext(), GustoActivity.class);
        int pos = getIntent().getIntExtra("RECETA", 0);
        i.putExtra("Receta", pos);
        startActivity(i);

    }

    public void Eliminar(View view){

    }
}