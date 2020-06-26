package com.example.parcial3_paredes_guerra_terrones_arango_duran.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Adaptadores.listview_adapter;
import com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades.Nombre;
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

        List<Nombre> nom = new ArrayList<Nombre>();

        nom.add(new Nombre("HOLA"));

        listview_adapter adapter= new listview_adapter(this, nom);
        lista.setAdapter(adapter);

    }

}