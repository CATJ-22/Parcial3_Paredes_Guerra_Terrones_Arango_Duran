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
    Button btnaddrecipe, btnreceguard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        name = getIntent().getStringExtra("nom");
        tipo = getIntent().getStringExtra("type");
        btnaddrecipe=(Button)findViewById(R.id.btn_agregar_recipes);
        btnreceguard=(Button)findViewById(R.id.btn_recetas_guardadas);

        /*try{
            RecetasBDHelper Datos = new RecetasBDHelper(getApplicationContext(), "Users",null, R.integer.DBVersion);
            SQLiteDatabase db = Datos.getReadableDatabase();
            Cursor c = db.rawQuery(" SELECT type FROM Users WHERE name='"+name+"'", null);

            if(c.moveToFirst()){
                tipo = c.getString(0);
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Errorsote: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }*/
        Toast.makeText(getApplicationContext(),tipo,Toast.LENGTH_LONG).show();

        if(tipo.equals("normal")){
            btnaddrecipe.setVisibility(View.INVISIBLE);
        }else if(tipo.equals("administrador")){
            btnreceguard.setVisibility(View.INVISIBLE);
        }
    }

    //RECETAS DISPONIBLES
    public void Recipes (View view){
        Intent i = new Intent(MenuActivity.this,Lista_recetaActivity.class);
        startActivity(i);
    }

    //GUARDAR RECETAS
    public void SaveRecipes (View view){
        Intent i = new Intent(MenuActivity.this, RecetasGuardasActivity.class);
        i.putExtra("type", tipo);
        startActivity(i);
    }

    //AGREGAR RECETAS
    public void AddRecipes (View view){
        Intent i = new Intent(MenuActivity.this, Agregar_RecetasActivity.class);
        startActivity(i);

    }

}