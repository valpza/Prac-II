package com.example.iowner.eva2_8_listas_personalizadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ClimaDetalle extends AppCompatActivity {
    ListView list;
    ImageView imgVw;
    TextView txtCiudad, txtTemp, txtDes;
    Intent iDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima_detalle);
        imgVw = findViewById(R.id.imgDe);
        txtCiudad = findViewById(R.id.txtCiDe);
        txtDes = findViewById(R.id.txtDeDe);
        txtTemp = findViewById(R.id.txtTEmDe);
        iDatos = getIntent();

        imgVw.setImageResource(iDatos.getIntExtra("img",0));
        txtCiudad.setText(iDatos.getStringExtra("ciu"));
        txtDes.setText(iDatos.getStringExtra("des"));
        txtTemp.setText(iDatos.getStringExtra("tem"));
    }
}
