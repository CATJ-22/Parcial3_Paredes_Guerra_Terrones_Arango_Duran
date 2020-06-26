package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Spinner;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class MainActivity extends AppCompatActivity {

    private final int DURACION_SPLASH = 3000;
    Spinner spnRecipes;
    int a;

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
            RecetasBDHelper smDB = new RecetasBDHelper(this, "users", null, 1);
            SQLiteDatabase db = smDB.getWritableDatabase();
            //se añadio los usuarios a la BD

            a++;

            if(a==1){
            db.execSQL("INSERT INTO users (name, email, password, type)" + "VALUES ('zamora','zamora@example.com','123','Administrador')");
            db.execSQL("INSERT INTO users (name, email, password, type)" + "VALUES ('elfo','elfo@example.com','123','Normal')");
            /*
            db.execSQL("INSERT INTO recipes (name, description, ingredients, restaurant, comments)" + "VALUES ('hamborguesa','cuadrada','pan carne queso y salsas','mcquetedandonals', 'jaja muy good')");
            db.execSQL("INSERT INTO fav_recipe (id_user, id_recipes)" + "VALUES (1,0)");

            db.execSQL("INSERT INTO recipes (name, description, ingredients, restaurant, comments)" + "VALUES ('panqueso','redondo','pan queso y mantequilla','zamosandwich', 'jaja verymucho good')");
            db.execSQL("INSERT INTO fav_recipe (id_user, id_recipes)" + "VALUES (1,1)");*/
            }

        } catch (Exception e) {

        }
    }

}
