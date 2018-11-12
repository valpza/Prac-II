package com.example.iowner.eva2_2_intentos_implicitos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Secundaria extends AppCompatActivity implements Button.OnClickListener {
    Button btnCerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        btnCerrar = findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
