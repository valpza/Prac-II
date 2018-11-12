package com.example.vale.eva2_prac_res;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleRes extends AppCompatActivity {

    TextView txtTitulo, txtDes,txtDirec,txtNum;
    Intent iDatos, iMarcar;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_res);
        txtTitulo= findViewById(R.id.txtTitulo);
        txtDes = findViewById(R.id.txtDescrip);
        txtDirec = findViewById(R.id.txtDirec);
        txtNum = findViewById(R.id.txtNum);
        iDatos = getIntent();

        linearLayout.setBackgroundResource(iDatos.getIntExtra("img",0));
        txtTitulo.setText(iDatos.getStringExtra("nom"));
        txtDes.setText(iDatos.getStringExtra("des"));
        txtDirec.setText(iDatos.getStringExtra("dir"));
        txtNum.setText("Tel: "+iDatos.getStringExtra("tel"));
    }

    public void click(View v){//llamar
        if(Principal.ban==true) {
            String sTel = "tel:" +iDatos.getStringExtra("tel");
            iMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
            startActivity(iMarcar);
        }else{
            Toast.makeText(this, "NO TIENES PERMISO PA LLAMAR PRRO", Toast.LENGTH_SHORT).show();

        }
    }
}
