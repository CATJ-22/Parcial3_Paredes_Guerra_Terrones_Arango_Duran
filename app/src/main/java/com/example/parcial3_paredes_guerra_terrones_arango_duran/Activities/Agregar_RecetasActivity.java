package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class Agregar_RecetasActivity extends AppCompatActivity {
    EditText name, id_recipes, description, ingredients, restaurant, comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__recetas);
        initializeControls();
    }

    public void initializeControls(){
        name=(EditText)findViewById(R.id.txt_name);
        id_recipes=(EditText)findViewById(R.id.txt_idrecipes);
        description=(EditText)findViewById(R.id.txt_description);
        ingredients=(EditText)findViewById(R.id.txt_ingredients);
        restaurant=(EditText)findViewById(R.id.txt_restaurant);
        comments=(EditText)findViewById(R.id.txt_comments);
    }

    public void saveRecipe(View view){
        String nombre= name.getText().toString();
        String id_receta=id_recipes.getText().toString();
        String descripcion=description.getText().toString();
        String ingrediente=ingredients.getText().toString();
        String restaurante=restaurant.getText().toString();
        String comentario=comments.getText().toString();

        RecetasBDHelper Datos = new RecetasBDHelper(getApplicationContext(), "Recipes",null, R.integer.DBVersion);
        SQLiteDatabase db = Datos.getWritableDatabase();

        if(db != null){
            ContentValues values = new ContentValues();
            values.put("name", nombre);
            values.put("id_recipes", id_receta);
            values.put("description", descripcion);
            values.put("ingredients", ingrediente);
            values.put("restaurant", restaurante);
            values.put("comments", comentario);

            //db.insert("Recipes", null, values);

            //db.close();

            //Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();

            //Intent i = new Intent(this, MenuActivity.class);
            //startActivity(i);
        }
    }
}