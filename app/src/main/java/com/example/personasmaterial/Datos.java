package com.example.personasmaterial;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Carro> lista;

    public static void guardar(Carro p){
        lista.add(p);
    }

    public static ArrayList<Carro> obtener() {
        return lista;
    }
}
