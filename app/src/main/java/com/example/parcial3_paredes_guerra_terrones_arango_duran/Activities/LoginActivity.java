package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class LoginActivity extends AppCompatActivity {
    EditText txtname;
    EditText txtpassword;
    Button btnsubmit;
    Button btnregister;
    String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cargarVariables();
    }

    public void cargarVariables(){
        txtname = (EditText) findViewById(R.id.TextPersonName);
        txtpassword = (EditText)findViewById(R.id.TextPassword);

    }

    // BUTTON LOGIN KIRIAM
    public void Submit (View view){
        try{
            //ASIGNAMOS A NUESTRAS VARIABLES EL CAMPO DE NAME Y PASSWORD
            String namepuesto= txtname.getText().toString();
            String passwordpuesto= txtpassword.getText().toString();

            if(namepuesto.equals("") && passwordpuesto.equals(""))
                Toast.makeText(getApplicationContext(), "Por favor llene el Formulario", Toast.LENGTH_SHORT).show();
            if(TextUtils.isEmpty(txtname.getText().toString())){
                txtname.setError("Porfavor ingrese su usuario.");
                Toast.makeText(getApplicationContext(), "USUARIO ESTA VACIO!", Toast.LENGTH_SHORT).show();
            }
            if(TextUtils.isEmpty(txtpassword.getText().toString())){
                txtpassword.setError("Porfavor ingrese su contraseña ");
                Toast.makeText(getApplicationContext(), "CONTRASEÑA ESTA VACIA!", Toast.LENGTH_SHORT).show();
            }


            // SE LLAMA LA BASE DE DATOS CREADA
            RecetasBDHelper smDB = new RecetasBDHelper(this, "users", null,1);
            SQLiteDatabase db = smDB.getWritableDatabase();
            // DAMOS APERTURA A LA BASE DE DATOS
            if(db !=null){
                // Creamos un arreglo quemado para usuarios
                String[] usuarios =new String[]{"id_user","name","email","password","type"};
                //Creamos el cursor
                Cursor c = db.query("users",usuarios,null,null,null,null,null);

                if(c!=null){
                    //Posicionar al principio el cursor
                    c.moveToFirst();
                    do{
                        String user_name = c.getString(c.getColumnIndex("name"));
                        String user_type = c.getString(c.getColumnIndex("type"));
                        String user_pass = c.getString(c.getColumnIndex("password"));

                        if(user_name.equals(namepuesto) && user_pass.equals(passwordpuesto)){

                            Intent i = new Intent(this, MenuActivity.class);
                            i.putExtra("nom", namepuesto);
                           //i.putExtra("password",user_pass);
                            i.putExtra("type",user_type);
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(), "ERROR NO SON COMPATIBLES", Toast.LENGTH_SHORT).show();
                        }

                    }while (c.moveToNext()); //mover a la siguiente linea
                }
                c.close();
                db.close();
            }

        }catch (Exception e) {
            Toast.makeText(this,"Error en la base de datos (No se han ingresado) -> " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }

    }

}