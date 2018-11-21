package com.example.vale.eva2_7_intentos_resultados;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtView;
    Intent inContactos,inImagnes;
    Uri uContactos,uImagenes;
    final int BUSCAR_CONTACTOS = 1000;
    final int BUSCAR_IMAGENES = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtView = findViewById(R.id.txtView);
        uContactos = ContactsContract.Contacts.CONTENT_URI;
        uImagenes = Uri.parse("content://media/external/images/media");

        inContactos = new Intent(Intent.ACTION_PICK,uContactos);
        inImagnes = new Intent(Intent.ACTION_PICK,uImagenes);
    }
    public void miClick(View v){
        startActivityForResult(inContactos,BUSCAR_CONTACTOS);
    }
    public void miClick2(View v){
        startActivityForResult(inImagnes,BUSCAR_IMAGENES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent inResul;
        switch(requestCode){
            case BUSCAR_CONTACTOS:
                if(resultCode == Activity.RESULT_OK){
                    String sResu = data.getDataString();
                    txtView.setText(sResu);
                    inResul = new Intent(Intent.ACTION_VIEW,Uri.parse(sResu));
                    startActivity(inResul);
                }
                break;
            case BUSCAR_IMAGENES:
                if(resultCode == Activity.RESULT_OK){
                    String sResu = data.getDataString();
                    txtView.setText(sResu);
                    inResul = new Intent(Intent.ACTION_VIEW,Uri.parse(sResu));
                    startActivity(inResul);
                }
                break;
        }
    }
}
