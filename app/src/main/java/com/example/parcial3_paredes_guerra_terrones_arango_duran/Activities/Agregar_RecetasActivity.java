package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class Agregar_RecetasActivity extends AppCompatActivity {
    EditText name, description, ingredients, restaurant, comments;
    TextView path_image;
    Intent file_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__recetas);
        initializeControls();
    }

    public void initializeControls(){
        name=(EditText)findViewById(R.id.txt_name);
        path_image=(TextView) findViewById(R.id.txt_routeRecipes);
        path_image.setEnabled(false);
        description=(EditText)findViewById(R.id.txt_description);
        ingredients=(EditText)findViewById(R.id.txt_ingredients);
        restaurant=(EditText)findViewById(R.id.txt_restaurant);
        comments=(EditText)findViewById(R.id.txt_comments);
        file_intent=new Intent(Intent.ACTION_GET_CONTENT);
    }

    //Boton para cargar Imagen.
    public void loadImage(View view){
        file_intent.setType("*/*");
        startActivityForResult(file_intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    path_image.setText(path);
                }
                break;
        }
    }

    //Metodo para salvar receta.
    public void saveRecipe(View view){
        try {
            String nombre= name.getText().toString();
            String ruta_img=path_image.getText().toString();
            String descripcion=description.getText().toString();
            String ingrediente=ingredients.getText().toString();
            String restaurante=restaurant.getText().toString();
            String comentario=comments.getText().toString();

            RecetasBDHelper Datos = new RecetasBDHelper(getApplicationContext(), "Recipes",null, R.integer.DBVersion);
            SQLiteDatabase db = Datos.getWritableDatabase();

            if(db != null){
                ContentValues values = new ContentValues();
                values.put("name", nombre);
                values.put("description", descripcion);
                values.put("ingredients", ingrediente);
                values.put("restaurant", restaurante);
                values.put("comments", comentario);
                values.put("image", ruta_img);

                db.insert("recipes", null, values);
                Toast.makeText(this, "Datos Insertados Correctamente", Toast.LENGTH_SHORT).show();

            }
        }catch (Exception e){
            Toast.makeText(this, "Error: "+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}