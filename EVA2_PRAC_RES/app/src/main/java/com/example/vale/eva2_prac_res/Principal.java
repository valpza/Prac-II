package com.example.vale.eva2_prac_res;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener {
    Restaurante[] restaurantes = {
            new Restaurante("Cafe Dead end","El mejor cafe",R.drawable.cafedeadend,"Calle 3 Col homero","324 464 2363",R.drawable.cafedeadend),
            new Restaurante("Cafe Lois","cafe al estilo de Lois",R.drawable.cafeloisl,"Calle 1 Col mendola","614 436 2354",R.drawable.cafeloisl),
            new Restaurante("Five Leaves","Ricos postres",R.drawable.fiveleaves,"Calle 42 Col lopez","633 325 6788",R.drawable.fiveleaves),
            new Restaurante("Cafe Lore","Cafes",R.drawable.cafelore,"Calle 10 Col Huerta","613 233 2353",R.drawable.cafelore),
            new Restaurante("Grahamavenue Meats","comidas en casa",R.drawable.grahamavenuemeats,"Calle 5 Col Huerta","639 244 3566",R.drawable.grahamavenuemeats),
            new Restaurante("Homei","Cafe loco",R.drawable.homei,"Calle inustria Col reyes","622 235 4345",R.drawable.homei),
            new Restaurante("Po's Atelier","Restaurante",R.drawable.posatelier,"Calle 8 Col veracruz","628 212 3223",R.drawable.posatelier),
            new Restaurante("Teakha","Carne y mas",R.drawable.teakha,"Calle 2 Col Centro","628 335 4443",R.drawable.upstate),
            new Restaurante("Traif","Comidas y cenas ",R.drawable.traif,"Calle Perez Col Norte","344 235 1123",R.drawable.traif),
            new Restaurante("Barra Fina","Restaurante Gourment",R.drawable.barrafina,"Calle 42 Col Industrias","619 354 3233",R.drawable.barrafina),
            new Restaurante("Confessional","Pizza confecion",R.drawable.confessional,"Calle Allende Col Emiliano","614 124 3325",R.drawable.confessional),
            new Restaurante("Donostia","Carnes y mas",R.drawable.donostia,"Calle 9 Col 34","614 235 43543",R.drawable.donostia),
            new Restaurante("Forkee Restaurant","Sandwich y paninis",R.drawable.forkeerestaurant,"Calle rios Col juan","614 111 2511",R.drawable.forkeerestaurant),
            new Restaurante("Haighs Chocolate","Los postres del mundo",R.drawable.haighschocolate,"Calle 1 Col loco","614 747 3327",R.drawable.haighschocolate),
            new Restaurante("Palomino Espresso","Cafes exprex",R.drawable.palominoespresso,"Calle la sierra Col benito","614 124 3263",R.drawable.palominoespresso),
            new Restaurante("Petiteoyster","mariscos del mar",R.drawable.petiteoyster,"Calle 2 Col cementerio","614 783 2245",R.drawable.petiteoyster),
            new Restaurante("Royaloak","Desayuno y mas",R.drawable.royaloak,"Calle 4 Sur Col noviembre","1111127",R.drawable.royaloak),
            new Restaurante("Thai Cafe","Cafes y postres resien hechos",R.drawable.thaicafe,"Calle sebastian Col los reyes","614 367 3532",R.drawable.thaicafe),
            new Restaurante("Upstate","Alitas y boules",R.drawable.upstate,"Calle 1 Col el loro","614 165 3534",R.drawable.upstate),
            new Restaurante("Wolf Waffles","Waffles",R.drawable.wafflewolf,"Calle 11va Col perico","614 123 2423",R.drawable.wafflewolf)
    };
    ListView list_Res;
    Intent iRestaute;
    public static boolean ban;
    final int MY_PERMISO = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},MY_PERMISO);
        }else
            ban = true;
        list_Res = findViewById(R.id.list_Res);
        list_Res.setAdapter(new Adapter(this, R.layout.restaurante, restaurantes));
        list_Res.setOnItemClickListener(this);
        iRestaute = new Intent(this, DetalleRes.class);
    }
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        iRestaute.putExtra("img",restaurantes[i].imagen);
        iRestaute.putExtra("imgG",restaurantes[i].imagenG);
        iRestaute.putExtra("nom",restaurantes[i].sNomRes);
        iRestaute.putExtra("des",restaurantes[i].sDes);
        iRestaute.putExtra("dir",restaurantes[i].sDirec);
        iRestaute.putExtra("tel",restaurantes[i].sTele);
        startActivity(iRestaute);
    }
    //SOLISITAR PERMISOS
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == MY_PERMISO){
            if((grantResults.length > 0)&& grantResults[0]== PackageManager.PERMISSION_GRANTED){
                ban = true;
            }
        }
    }
}
