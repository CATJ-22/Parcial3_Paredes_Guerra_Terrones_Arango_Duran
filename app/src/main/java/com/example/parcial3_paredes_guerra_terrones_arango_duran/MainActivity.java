package com.example.parcial3_paredes_guerra_terrones_arango_duran;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ImpresionDatos();
    }

    private void ImpresionDatos(){
        try{
            BD_Recetas smDB = new BD_Recetas(this,"Users",null, 1);
            SQLiteDatabase db = smDB.getWritableDatabase();
        }catch (Exception e){

        }
    }
}