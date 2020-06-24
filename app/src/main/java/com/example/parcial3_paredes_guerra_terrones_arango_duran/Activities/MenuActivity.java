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

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        name = getIntent().getStringExtra("nom");
        boton=(Button)findViewById(R.id.btagrerece);

        try{
            RecetasBDHelper Datos = new RecetasBDHelper(getApplicationContext(), "Users",null, R.integer.DBVersion);
            SQLiteDatabase db = Datos.getReadableDatabase();
            Cursor c = db.rawQuery(" SELECT type FROM Users WHERE name='"+name+"'", null);
            tipo = c.getString(0);
            Toast.makeText(getApplicationContext(),tipo,Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Errorsote: "+e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }

        if(tipo.equals("normal")){
            boton.setVisibility(View.INVISIBLE);
        }
    }

    public void recetasdispo (View view){
        Intent intent = new Intent(MenuActivity.this, Lista_recetaActivity.class);
        startActivity(intent);
    }
    public void recetasguar (View view){
        Intent intent = new Intent(MenuActivity.this, RecetasGuardasActivity.class);
        startActivity(intent);
    }

    public void addrecet (View view){
        Intent intent = new Intent(MenuActivity.this, Agregar_RecetasActivity.class);
        startActivity(intent);
    }

}