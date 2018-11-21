package com.example.vale.eva2_2_intentos_implicitos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity implements Button.OnClickListener{
    Button btnSecundaria;
    Intent inLanzarSecun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnSecundaria = findViewById(R.id.btnSecundaria);
        inLanzarSecun = new Intent(this,Secundaria.class);
        btnSecundaria.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(inLanzarSecun);
        finish();
    }
}
