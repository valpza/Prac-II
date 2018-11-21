package com.example.vale.eva2_5_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Secundaria extends AppCompatActivity {
    EditText editTxtEnviar;
    Intent inPrimaria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        editTxtEnviar = findViewById(R.id.editTxtEnviar);
        inPrimaria = getIntent();
    }
    public void click(View v){
        String datos=editTxtEnviar.getText().toString();
        inPrimaria.putExtra("dato",datos);
        setResult(Activity.RESULT_OK,inPrimaria);
        finish();

    }
}
