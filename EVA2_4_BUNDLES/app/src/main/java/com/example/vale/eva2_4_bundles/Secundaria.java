package com.example.vale.eva2_4_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Secundaria extends AppCompatActivity implements Button.OnClickListener{
    TextView txtViewDatos;
    Button btnCerrar;
    Intent inRecibido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        txtViewDatos = findViewById(R.id.txtViewDatos);
        btnCerrar = findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(this);
        inRecibido = getIntent();
        Bundle datosRecibidos = inRecibido.getExtras();
        txtViewDatos.append("Nombre: "+datosRecibidos.get("Nombre")+"\n");
        txtViewDatos.append("Apellido: "+datosRecibidos.get("Apellido")+"\n");
        txtViewDatos.append("Edad: "+datosRecibidos.get("Edad")+"\n");

        if(datosRecibidos.getBoolean("Empleado")){
            txtViewDatos.append("Trabaja: Si"+"\n");
            txtViewDatos.append("Salario: "+datosRecibidos.getDouble("Salario")+"\n");
        }else
            txtViewDatos.append("Trabaja: No"+"\n");
        txtViewDatos.append("Genero: "+datosRecibidos.get("Genero")+"\n");

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Adios  "+inRecibido.getStringExtra("Nombre"), Toast.LENGTH_LONG).show();
        finish();
    }
}
