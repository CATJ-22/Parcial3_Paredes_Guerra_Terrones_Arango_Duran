package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;

public class LoginActivity extends AppCompatActivity {
    EditText nombre;
    String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cargarVariables();
    }

    public void cargarVariables(){
        nombre = (EditText) findViewById(R.id.TextPersonName);

    }

    public void mainmenu (View view){
        String nomb= nombre.getText().toString();
        Intent i = new Intent(this, MenuActivity.class);
        i.putExtra("nom", nomb);
        startActivity(i);
    }
}