package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class CreateUserActivity extends AppCompatActivity {
    EditText txtname;
    EditText txtemail;
    EditText txtpassword;
    Spinner options;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        this.InicializarControles();
        this.AttachEventSpn();
    }

    public void InicializarControles() {
        txtname = (EditText) findViewById(R.id.txtname);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        options = (Spinner) findViewById(R.id.spOptions);
        this.LoadSpinners();
    }

    //CARGAR SPINNER
    public void LoadSpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.users, android.R.layout.simple_spinner_item);
        options.setAdapter(adapter);
    }

    private void AttachEventSpn() {
        options.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                String opciones = adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(getApplicationContext(), opciones, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //BOTON REGISTRAR
    public void Registrar(View view) {

        if (options.getSelectedItem().equals("Administrador")) {
            Administrador();
        } else if (options.getSelectedItem().equals("Usuario Normal")) {
            Usuario();
        }
    }

    //ADMNISTRADOR
    public void Administrador() {
        try {
            // Se llama a la base de Dato creada
            RecetasBDHelper smDB = new RecetasBDHelper(this, "users", null, 1);
            SQLiteDatabase db = smDB.getWritableDatabase();
            // Se inicializa y se asignan variables
            String name = txtname.getText().toString();
            String email = txtemail.getText().toString();
            String pass = txtpassword.getText().toString();
            String user_type = options.getSelectedItem().toString();
            // Damos Apertura a la base de datos
            if (db != null) {
                ContentValues values = new ContentValues();
                //Agregamos los valores a nuestra base de datos
                values.put("name", name);
                values.put("email", email);
                values.put("password", pass);
                values.put("type", user_type);
                db.insert("users", null, values);
                Toast.makeText(getApplicationContext(), "Los datos del administrador han sido insertados", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error en la base de datos (No se han ingresado) -> " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }

    //USUARIO NORMAL
    public void Usuario() {
        try {
            // Se llama a la base de Dato creada
            RecetasBDHelper smDB = new RecetasBDHelper(this, "users", null, 1);
            SQLiteDatabase db = smDB.getWritableDatabase();
            // Se inicializa y se asignan variables
            String name = txtname.getText().toString();
            String email = txtemail.getText().toString();
            String pass = txtpassword.getText().toString();
            String user_type = options.getSelectedItem().toString();
            // Damos Apertura a la base de datos
            if (db != null) {
                ContentValues values = new ContentValues();
                //Agregamos los valores a nuestra base de datos
                values.put("name", name);
                values.put("email", email);
                values.put("password", pass);
                values.put("type", user_type);
                db.insert("users", null, values);
                Toast.makeText(getApplicationContext(), "Los datos del administrador han sido insertados", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error en la base de datos (No se han ingresado) -> " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }

    //BOTON Volver a login
    public void Login(View view) {
        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
    }

}