package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Spinner;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class MainActivity extends AppCompatActivity {

    private final int DURACION_SPLASH = 3000;
    Spinner spnRecipes;

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
            RecetasBDHelper smDB = new RecetasBDHelper(this, "Users", null, 1);
            SQLiteDatabase db = smDB.getWritableDatabase();
        } catch (Exception e) {

        }
    }

    public void LoadRecipes(){
        try{
            RecetasBDHelper recetasDb = new RecetasBDHelper(getApplicationContext(),"Apettito",null,R.integer.DBVersion);
            SQLiteDatabase db = recetasDb.getWritableDatabase();



    //CARGAR LA TABLAS RECIPES

            if (db != null){
                db.delete("recipes",null,null );
                String rec[]={"Hamburguesa"};
                String ingredients[]={"Pan"};
                String description[]={"Cocinar el pan"};
                String restaurant[]={"Cocinar el pan"};
                String comments[]={"Cocinar el pan"};

                for(int i =1; i<=rec.length;i++){
                    ContentValues c = new ContentValues();
                    c.put("name",rec[i]);
                    c.put("id_recipes",i);
                    c.put("description",description[i]);
                    c.put("restaurant",restaurant[i]);
                    c.put("comments",comments[i]);
                    db.insert("recipes",null,c);
                }

            }

        }catch (Exception e){

        }
    }
}
