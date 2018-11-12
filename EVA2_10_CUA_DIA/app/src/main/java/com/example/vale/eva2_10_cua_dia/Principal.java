package com.example.vale.eva2_10_cua_dia;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
    public void Click(View v) {
        new AlertDialog.Builder(this).setTitle("Mi cuadrito de dialogo").setMessage("Cuadrito de dialogo como JOptionPane").setPositiveButton("Ta bueno", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Principal.this, "Click positivo", Toast.LENGTH_SHORT).show();
            }
        }).setNeutralButton("Ta neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Principal.this, "Click Neural", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Ta malo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Principal.this, "Click negativo", Toast.LENGTH_SHORT).show();
            }
        }).create().show();


    }

    public void Myclick(View v) {
        final Dialog dMiCuadroDialogo = new Dialog(this);
        dMiCuadroDialogo.setContentView(R.layout.mi_cuadro_dialogo);
        TextView lblTexto;
        final EditText txtNombre;
        Button btnOk;

        lblTexto = dMiCuadroDialogo.findViewById(R.id.lblTexto);
        txtNombre = dMiCuadroDialogo.findViewById(R.id.txtNombre);
        btnOk = dMiCuadroDialogo.findViewById(R.id.btnOK);
        lblTexto.setText("MI CUADRO PERZONALIZADO");
        txtNombre.setHint("Introduce nombre");
        btnOk.setText("Saluda :)");
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Principal.this, txtNombre.getText().toString(), Toast.LENGTH_SHORT).show();
                dMiCuadroDialogo.dismiss();
            }
        });
        dMiCuadroDialogo.show();
    }
}

