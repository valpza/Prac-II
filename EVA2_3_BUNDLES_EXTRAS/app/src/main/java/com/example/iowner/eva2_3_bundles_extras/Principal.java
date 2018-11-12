package com.example.iowner.eva2_3_bundles_extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity implements Button.OnClickListener{
    Intent inSecun;
    EditText editText;
    Button btnSecun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inSecun = new Intent(this,Secundaria.class);
        editText = findViewById(R.id.editText);
        btnSecun = findViewById(R.id.btnSecun);
        btnSecun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String sCade = editText.getText().toString();
        inSecun.putExtra("Mensaje",sCade);
        startActivity(inSecun);
    }
}
