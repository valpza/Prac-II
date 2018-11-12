package com.example.luisflores.eva2_1_intentos;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Principal extends AppCompatActivity {

    EditText txtNumero;
    Intent inMarcar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtNumero = findViewById(R.id.txtNumero);
    }

    public void click(View view) {
        String sTel = txtNumero.getText().toString();
        sTel = "tel: " + sTel;
        inMarcar = new Intent(Intent.ACTION_DIAL, Uri.parse(sTel));
        startActivity(inMarcar);

    }
    public void clickLlamar(View view) {
        String sTel = txtNumero.getText().toString();
        sTel = "tel: " + sTel;
        inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(inMarcar);

    }
    public void clickWeb(View view) {

        inMarcar = new Intent(Intent.ACTION_WEB_SEARCH);
        inMarcar.putExtra(SearchManager.QUERY,"flash");
        startActivity(inMarcar);

    }

}
