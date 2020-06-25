package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {


    String tipo="", name="";
    Button btnaddrecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        name = getIntent().getStringExtra("nom");
        btnaddrecipe=(Button)findViewById(R.id.btn_add_recipes);
/*
        try{
            RecetasBDHelper Datos = new RecetasBDHelper(getApplicationContext(), "Users",null, R.integer.DBVersion);
            SQLiteDatabase db = Datos.getReadableDatabase();
            Cursor c = db.rawQuery(" SELECT type FROM Users WHERE name='"+name+"'", null);

            if(c.moveToFirst()){
                tipo = c.getString(0);
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Errorsote: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }

        if(tipo.equals("normal")){
            btnaddrecipe.setVisibility(View.INVISIBLE);
        }*/
    }

    //RECETAS DISPONIBLES
    public void Recipes (View view){
        /*Intent i = getIntent();
        tipo=i.getStringExtra("type");
       /* if(tipo_logueado.equals("Administrador")){
            Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
            Intent crear = new Intent(MainActivity.this, CrearUsuarioActivity.class);
            startActivity(crear);
        } else
            item.setVisible(true);
        Intent a = new Intent(MenuActivity.this, Lista_recetaActivity.class);
        startActivity(a);*/
        Intent i = new Intent(getApplicationContext(),Lista_recetaActivity.class);
        startActivity(i);
    }

    //GUARDAR RECETAS
    public void SaveRecipes (View view){
        /*Intent b = new Intent(MenuActivity.this, RecetasGuardasActivity.class);
        b.putExtra("nom", name);
        startActivity(b);*/
        Intent i = new Intent(getApplicationContext(),CreateUserActivity.class);
        startActivity(i);
    }

    //AGREGAR RECETAS
    public void AddRecipes (View view){
        /*
        Intent c = new Intent(MenuActivity.this, Agregar_RecetasActivity.class);
        startActivity(c);

         */
        Intent i = new Intent(getApplicationContext(),Agregar_RecetasActivity.class);
        startActivity(i);
    }

}