package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD_Recetas;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class MainActivity extends AppCompatActivity {

    private final int DURACION_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ImpresionDatos();

        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

            ;
        }, DURACION_SPLASH);

    }


    private void ImpresionDatos() {
        try {
            BD_Recetas smDB = new BD_Recetas(this, "Users", null, 1);
            SQLiteDatabase db = smDB.getWritableDatabase();
        } catch (Exception e) {

        }
    }
}
