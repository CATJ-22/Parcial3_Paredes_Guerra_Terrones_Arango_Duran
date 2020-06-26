package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Adaptadores.listview_adapter;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Adaptadores.listview_adapter2;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.BD.RecetasBDHelper;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades.Nombre;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades.Nombre2;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.R;
import java.util.ArrayList;
import java.util.List;

public class RecetasGuardasActivity extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas_guardas);

        this.InicializarControles();
    }

    private void InicializarControles() {

        lista=(ListView)findViewById(R.id.listview);

        this.LoadListView();
    }

    private void LoadListView() {

        RecetasBDHelper admin = new RecetasBDHelper(this, "users", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        List<Nombre2> nomb = new ArrayList<>();

        Cursor cursor = BaseDeDatos.rawQuery
                ("select like_recipe, dislike_recipe from fav_recipes", null);

        if (cursor.moveToFirst()) {

            do {
                Nombre2 name = new Nombre2(
                        cursor.getString(0),
                        cursor.getString(1)
                );

                nomb.add(name);
            } while (cursor.moveToNext());
        }

        BaseDeDatos.close();

        listview_adapter2 adapter = new listview_adapter2(this, nomb);
        lista.setAdapter(adapter);

    }

}
