package com.example.iowner.eva2_8_listas_personalizadas;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iOwner on 18/10/2018.
 */

public class ClimaAdpater extends ArrayAdapter<Clima> {
    Context cContexto;
    int iLayoaut;
    Clima[] aCiudades;
    public ClimaAdpater(@NonNull Context context, int resource, @NonNull Clima[] objects) {
        super(context, resource, objects);
        cContexto = context;
        iLayoaut = resource;
        aCiudades = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVw;
        TextView txtCiudad, txtTemp, txtDes;

        View vFila = convertView;
        if(vFila == null){//no existe fila creeamos
            //PARA CREAR LA VISTA USAMOS LAYOUTINFLATER
            LayoutInflater liVista = ((Activity)cContexto).getLayoutInflater();
            vFila = liVista.inflate(iLayoaut,parent,false);

        }
        //VINCULAR WIDGETS
        imgVw = vFila.findViewById(R.id.imgVw);
        txtCiudad = vFila.findViewById(R.id.txtCiudad);
        txtDes = vFila.findViewById(R.id.txtDes);
        txtTemp = vFila.findViewById(R.id.txtTemp);

        Clima cActual = aCiudades[position];

        imgVw.setImageResource(cActual.imagen);
        txtCiudad.setText(cActual.nombreCiudad);
        txtDes.setText(cActual.descripcion);
        txtTemp.setText(cActual.temperatura+"");
        return vFila;
    }
}
