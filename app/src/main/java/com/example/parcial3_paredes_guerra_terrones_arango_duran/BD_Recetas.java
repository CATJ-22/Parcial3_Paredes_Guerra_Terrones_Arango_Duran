package com.example.parcial3_paredes_guerra_terrones_arango_duran;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//CREACIÓN DE LA BASE DE DATOS
public class BD_Recetas extends SQLiteOpenHelper {



    public BD_Recetas(Context context, String nombre, SQLiteDatabase.CursorFactory cursorFactory, int version) {
       super(context, nombre, cursorFactory, 1);
   }
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(Utilidades.CREAR_TABLA_USERS);
       db.execSQL(Utilidades.CREAR_TABLA_RECIPES);
   }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS Recipes");


        //Se crea la nueva versión de la tabla
        db.execSQL(Utilidades.CREAR_TABLA_USERS);
        db.execSQL(Utilidades.CREAR_TABLA_RECIPES);
    }

}
