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
            db.execSQL("INSERT INTO users (name, email, password, type)" + "VALUES ('zamora','zamora@example.com','123','Administrador')");
            db.execSQL("INSERT INTO users (name, email, password, type)" + "VALUES ('elfo','elfo@example.com','123','Normal')");
            db.execSQL("INSERT INTO recipes (name, description, ingredients, restaurant, comments)" + "VALUES ('hamborguesa','cuadrada','pan carne queso y salsas','mcquetedandonals', 'jaja muy good')");
            db.execSQL("INSERT INTO fav_recipe (id_user, id_recipes)" + "VALUES (0,0)");
            db.execSQL("INSERT INTO recipes (name, description, ingredients, restaurant, comments)" + "VALUES ('panqueso','redondo','pan queso y mantequilla','zamosandwich', 'jaja verymucho good')");
            db.execSQL("INSERT INTO fav_recipe (id_user, id_recipes)" + "VALUES (1,1)");
            /*KIRIAM
            if(db != null) {
                db.execSQL("INSERT INTO users (name, email, password, type)" + "VALUES ('zamora','zamora@example.com','123','Administrador')");

                String[] usuarios = new String[]{"id_user", "name", "email", "password", "type"};
                Cursor c = db.query("users", usuarios, null, null, null, null, null);

                if(c!=null){
                    //Posicionar al principio el cursor
                    c.moveToFirst();
                    do{

                        String name = c.getString(c.getColumnIndex("name"));
                        String pass = c.getString(c.getColumnIndex("password"));
                        Intent e = getIntent();
                        String namepuesto= e.getStringExtra("name");
                        String passwordpuesto=  e.getStringExtra("password");

                        if(name.equals(namepuesto) && pass.equals(passwordpuesto)){
                            String user_type = c.getString(c.getColumnIndex("type"));
                            String user_name = c.getString(c.getColumnIndex("name"));
                            String user_pass = c.getString(c.getColumnIndex("password"));
                            type.setText(user)
                        }*/




                /*  if(db !=null){
                // Creamos un arreglo quemado para usuarios
                String[] usuarios =new String[]{"id_user","name","email","password","type"};
                //Creamos el cursor
                Cursor c = db.query("users",usuarios,null,null,null,null,null);

                if(c!=null){
                    //Posicionar al principio el cursor
                    c.moveToFirst();
                    do{
                        String user_type = c.getString(c.getColumnIndex("type"));
                        String user_name = c.getString(c.getColumnIndex("name"));
                        String user_pass = c.getString(c.getColumnIndex("password"));

                        if(user_name.equals(namepuesto) && user_pass.equals(passwordpuesto)){
                            Toast.makeText(getApplicationContext(), "WELCOME"+ user_type, Toast.LENGTH_LONG).show();
                            Intent i = new Intent(this, MenuActivity.class);
                            i.putExtra("name", user_name);
                            i.putExtra("password",user_pass);
                            i.putExtra("type",user_type);
                            startActivity(i);
                        }

                    }while (c.moveToNext()); //mover a la siguiente linea
                }
                c.close();
                db.close();
            }*/

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
