package com.example.iowner.eva2_1_intentos;

        import android.app.SearchManager;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;

public class Principal extends AppCompatActivity {
    EditText editTxtNumero;
    Intent inMarcar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        editTxtNumero = findViewById(R.id.editTxtNumero);
    }

    public void click(View v){
        String sTel = "tel:"+editTxtNumero.getText().toString();
        inMarcar = new Intent(Intent.ACTION_DIAL, Uri.parse(sTel));
        startActivity(inMarcar);

    }
    public void clickLlamar(View v){
        String sTel = "tel:"+editTxtNumero.getText().toString();
        inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(inMarcar);

    }
    public void clickBuscar(View v){
        inMarcar = new Intent(Intent.ACTION_WEB_SEARCH);
        inMarcar.putExtra(SearchManager.QUERY,"PERRITOS");
        startActivity(inMarcar);

    }

}
