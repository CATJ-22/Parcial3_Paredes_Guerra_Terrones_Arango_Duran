package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    String tipo="", name="";
    Button btnaddrecipe, btnreceguard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        name = getIntent().getStringExtra("nom");
        tipo = getIntent().getStringExtra("type");
        btnaddrecipe=(Button)findViewById(R.id.btn_agregar_recipes);
        btnreceguard=(Button)findViewById(R.id.btn_recetas_guardadas);
        Toast.makeText(getApplicationContext(), "Bienvenido "+ name, Toast.LENGTH_LONG).show();
        //validacion de visibilidad para botones por tipo de usuario
        if(tipo.equalsIgnoreCase("normal")){
            btnaddrecipe.setVisibility(View.INVISIBLE);
        }

        if(tipo.equalsIgnoreCase("administrador")){
            btnreceguard.setVisibility(View.INVISIBLE);
        }
    }

    //RECETAS DISPONIBLES
    public void Recipes (View view){
        Intent i = new Intent(MenuActivity.this,Lista_recetaActivity.class);
        i.putExtra("type", tipo);
        startActivity(i);
    }

    //GUARDAR RECETAS
    public void SaveRecipes (View view){
        Intent i = new Intent(MenuActivity.this, RecetasGuardasActivity.class);

        startActivity(i);
    }

    //AGREGAR RECETAS
    public void AddRecipes (View view){
        Intent i = new Intent(MenuActivity.this, Agregar_RecetasActivity.class);
        startActivity(i);

    }

}