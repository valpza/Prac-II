package com.example.iowner.eva2_8_listas_personalizadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener{
    Clima[] climas = {new Clima("Chihuahua","Soleado", 15, R.drawable.rainy),
            new Clima("Delicias","Nublado", 10, R.drawable.cloudy),
            new Clima("Cuauhtemoc","Soleado", 20, R.drawable.sunny),
            new Clima("Camargo","Despejado", 17, R.drawable.rainy),
            new Clima("Creel","Soleado", 18, R.drawable.sunny),
            new Clima("Juarez","Soleado", 16, R.drawable.cloudy),
            new Clima("Ojinaga","Soleado", 10, R.drawable.sunny),
            new Clima("Aldama","Soleado", 15, R.drawable.rainy)};
    ListView list;
    ImageView imgVw;
    TextView txtCiudad, txtTemp, txtDes;
    Intent iClima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        list = findViewById(R.id.list);
        list.setAdapter(new ClimaAdpater(this,R.layout.layout_clima,climas));
        list.setOnItemClickListener(this);
        iClima = new Intent(this,ClimaDetalle.class);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        iClima.putExtra("img",climas[i].imagen);
        iClima.putExtra("ciu",climas[i].nombreCiudad);
        iClima.putExtra("tem",climas[i].temperatura);
        iClima.putExtra("des",climas[i].descripcion);
        startActivity(iClima);

    }
}
