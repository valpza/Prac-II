package com.example.vale.eva2_prac_res;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<Restaurante> {
    Context cContexto;
    int iLayout;
    Restaurante[] aRestaurantes;
    public Adapter(@NonNull Context context, int resource, @NonNull Restaurante[] objects) {
        super(context, resource, objects);
        cContexto = context;
        iLayout = resource;
        aRestaurantes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout lLinea;
        TextView txtRes, txtDes;

        View VFila = convertView;
        if(VFila == null){
            LayoutInflater liVista = ((Activity)cContexto).getLayoutInflater();
            VFila = liVista.inflate(iLayout,parent,false);

        }
        // WIDGETS
        lLinea = VFila.findViewById(R.id.layout);
        txtRes = VFila.findViewById(R.id.txtRes);
        txtDes = VFila.findViewById(R.id.txtDet);

        Restaurante cActual = aRestaurantes[position];

        lLinea.setBackgroundResource(cActual.imagen);
        txtRes.setText(cActual.sNomRes);
        txtDes.setText(cActual.sDes);
        return VFila;
    }
}
