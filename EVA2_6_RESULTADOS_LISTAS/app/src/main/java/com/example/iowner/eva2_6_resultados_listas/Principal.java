package com.example.iowner.eva2_6_resultados_listas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txt2,txtPrecio;
    Intent inResta,inPrecio;
    final int LISTA_RESTA = 100;
    final int PRECIO = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txt2 = findViewById(R.id.txt2);
        txtPrecio = findViewById(R.id.txtTotal);
        inResta = new Intent(this,ListaRestaurantes.class);
        inPrecio = new Intent(this,Orden.class);
    }
    public void click(View v){
        startActivityForResult(inResta,LISTA_RESTA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== LISTA_RESTA){
            if(resultCode == Activity.RESULT_OK){
                int iResta = data.getIntExtra("Restaurante",0);
                txt2.setText(Datos.sResta[iResta]);
            }
        }
        if(requestCode==PRECIO){
            if(resultCode == Activity.RESULT_OK){
                txtPrecio.setText(""+data.getDoubleExtra("Resultado",0));
            }
        }
    }
    public void click2(View v){
        startActivityForResult(inPrecio,PRECIO);
    }
}
