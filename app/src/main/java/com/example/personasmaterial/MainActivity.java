package com.example.personasmaterial;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorCarro.CarroViewHolder.OnCarroClickListener {
    private RecyclerView listadoCarros;
    private AdaptadorCarro adaptador;
    private LinearLayoutManager llm;
    private ArrayList<Carro> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listadoCarros = findViewById(R.id.lstPersonas);

        personas = new ArrayList<Carro>();
        personas.add(new Carro("1192773681", "Jesus", "Urueta", "azul", 1000, R.drawable.kia));
        personas.add(new Carro("123456", "Danny", "Ospino", "azul", 1200, R.drawable.chevrolet));
        personas.add(new Carro("789456", "Miguel", "Rico", "azul", 13000, R.drawable.mazda));

        adaptador = new AdaptadorCarro(personas, this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listadoCarros.setLayoutManager(llm);
        listadoCarros.setAdapter(adaptador);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void OnCarroClick(Carro c) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putInt("foto", c.getFoto());
        bundle.putString("placa", c.getPlaca());
        bundle.putString("marca", c.getMarca());
        bundle.putString("modelo", c.getModelo());
        bundle.putString("precio", "" + c.getPrecio());

        intent = new Intent(MainActivity.this, DetalleCarro.class);
        intent.putExtra("datos", bundle);
        startActivity(intent);
    }
}