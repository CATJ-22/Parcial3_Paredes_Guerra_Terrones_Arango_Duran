package com.example.parcial3_paredes_guerra_terrones_arango_duran.BD;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

//CREACIÓN DE LA BASE DE DATOS
public class RecetasBDHelper extends SQLiteOpenHelper {

    String tableUsers = "CREATE TABLE users(id_user INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, email TEXT, password TEXT, type TEXT)";
    String tableRecipes = "CREATE TABLE recipes( id_recipes INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT, ingredients TEXT, restaurant TEXT, comments TEXT, image TEXT)";
    String tableFav_recipe = "CREATE TABLE fav_recipe(id_user INTEGER, id_recipes INTEGER, PRIMARY KEY (id_user, id_recipes), FOREIGN KEY (id_user) REFERENCES users(id_user),FOREIGN KEY (id_recipes) REFERENCES recipes(id_recipes))";
    public RecetasBDHelper(Context context, String nombre, SQLiteDatabase.CursorFactory cursorFactory, int version) {
       super(context, nombre, cursorFactory, R.integer.DBVersion);
   }
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(tableUsers);
       db.execSQL(tableRecipes);
       db.execSQL(tableFav_recipe);
   }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Se elimina la versión anterior de la tabla
       /* db.execSQL("DROP TABLE IF EXISTS tableUsers");
        db.execSQL("DROP TABLE IF EXISTS tableRecipes");
        db.execSQL("DROP TABLE IF EXISTS tableFav_recipe");
*/

        //Se crea la nueva versión de la tabla
        db.execSQL(tableUsers);
        db.execSQL(tableRecipes);
        db.execSQL(tableFav_recipe);
    }

}
