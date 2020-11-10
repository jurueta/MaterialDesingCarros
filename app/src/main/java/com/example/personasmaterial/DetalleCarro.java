package com.example.personasmaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleCarro extends AppCompatActivity {
    private ImageView foto;
    private TextView placa, marca, modelo, valor;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_carro);

        foto = findViewById(R.id.imgFotoDetalle);
        placa = findViewById(R.id.lblPLacaDetalle);
        marca = findViewById(R.id.lblMarcaDetalle);
        modelo = findViewById(R.id.lblModeloDetalle);
        valor = findViewById(R.id.lblPrecioDetalle);

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");

        foto.setImageResource(bundle.getInt("foto"));
        placa.setText(bundle.getString("placa"));
        marca.setText(bundle.getString("marca"));
        modelo.setText(bundle.getString("modelo"));
        valor.setText(bundle.getString("precio"));
    }
}