package com.example.vale.eva2_6_resultados_listas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Orden extends AppCompatActivity {
    EditText editTxtCantidad,editTxtPrecio;
    Intent inDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);
        editTxtCantidad = findViewById(R.id.editTxtCantidad);
        editTxtPrecio = findViewById(R.id.editTxtPrecio);
        inDatos = getIntent();
    }
    public void click(View v){
        int iCant = Integer.parseInt(editTxtCantidad.getText().toString());
        double iPrecio = Double.parseDouble(editTxtPrecio.getText().toString());
        inDatos.putExtra("Resultado",(iCant*iPrecio));
        setResult(Activity.RESULT_OK,inDatos);
        finish();
    }
}
