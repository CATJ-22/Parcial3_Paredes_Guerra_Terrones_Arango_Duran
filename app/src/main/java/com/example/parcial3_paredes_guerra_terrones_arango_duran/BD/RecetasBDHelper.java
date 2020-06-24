package com.example.parcial3_paredes_guerra_terrones_arango_duran.BD;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

//CREACIÓN DE LA BASE DE DATOS
public class RecetasBDHelper extends SQLiteOpenHelper {
    String tableRecipes = "CREATE TABLE recipes(name TEXT, id_recipes TEXT, description TEXT, ingredients TEXT, restaurant TEXT, comments TEXT, image TEXT)";
    String tableUsers = "CREATE TABLE users(name TEXT, id TEXT, email TEXT, password TEXT, type TEXT)";



    public RecetasBDHelper(Context context, String nombre, SQLiteDatabase.CursorFactory cursorFactory, int version) {
       super(context, nombre, cursorFactory, R.integer.DBVersion);
   }
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(tableUsers);
       db.execSQL(tableRecipes);
   }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS Recipes");


        //Se crea la nueva versión de la tabla
        db.execSQL(tableUsers);
        db.execSQL(tableRecipes);
    }

}
