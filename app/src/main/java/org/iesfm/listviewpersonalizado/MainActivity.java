package org.iesfm.listviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ListView lvGraficas;
    private Map<String, Integer> seleccionGraficas = new HashMap<>();
    private int contador60;
    private int contador70;
    private int contador80;
    private int contadorTi;

    protected static final String GRAFICAS = "org.iesfm.listviewpersonalizado.graficas";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {

        lvGraficas = (ListView) findViewById(R.id.lvGraficas);
        contador60 = 0;
        contador70 = 0;
        contador80 = 0;
        contadorTi = 0;

        crearListView();

    }

    public void crearListView() {
        String[] graficas = {"rtx 3060", "rtx 3070", "rtx 3080", "rtx 3080ti"};

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_view_custom, R.id.tvAux, graficas);

        lvGraficas.setAdapter(adapter);

        lvGraficas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Ha seleccionado" + lvGraficas.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        contador60++;
                        seleccionGraficas.put("rtx 3060", contador60);

                        break;
                    case 1:
                        contador70++;
                        seleccionGraficas.put("rtx 3070", contador70);

                        break;
                    case 2:
                        contador80++;
                        seleccionGraficas.put("rtx 3080", contador80);

                        break;
                    case 3:
                        contadorTi++;
                        seleccionGraficas.put("rtx 3080ti", contadorTi);

                        break;
                }
            }
        });
    }


    public void enviar(View v) {

        Intent datos = new Intent(this, Datos.class);
        datos.putExtra(GRAFICAS, seleccionGraficas.toString());


        startActivity(datos);
    }
}