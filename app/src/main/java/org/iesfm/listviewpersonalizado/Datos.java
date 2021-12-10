package org.iesfm.listviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Datos extends AppCompatActivity {

    private String seleccion;

    private TextView datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        getInfo();
    }

    public void getInfo() {
        Intent main = getIntent();
        seleccion = main.getStringExtra(MainActivity.GRAFICAS);
        datos = (TextView) findViewById(R.id.tvDatos);
        seleccion.replace("{","");
        datos.setText(seleccion);

    }

    public void volver(View v) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}