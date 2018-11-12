package com.example.iowner.eva2_9_permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    EditText editTxtTel;
    Intent llamada;
    final int MY_PERMISSON = 1000;
    boolean bBande = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!=
        PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},MY_PERMISSON);
        }else
            bBande = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        editTxtTel = findViewById(R.id.editTxtTel);
    }
    public void click(View v){
        if(bBande) {
            String sTel = "tel:" + editTxtTel.getText().toString();
            llamada = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
            startActivity(llamada);
        }else{
            Toast.makeText(this, "NO TIENES MERMISO PARA LLAMAR", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == MY_PERMISSON){
            if((grantResults.length > 0)&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
                bBande = true;
            }
        }
    }
}
