package com.example.personasmaterial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder>{
    private ArrayList<Persona> personas;

    public AdaptadorPersona(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carro, parent, false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        Persona p = personas.get(position);
        holder.foto.setImageResource(p.getFoto());
        holder.nombre.setText(p.getNombre());
        holder.apellido.setText(p.getApellido());
        holder.cedula.setText(p.getCedula());
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView foto;
        private TextView cedula, nombre, apellido;
        private View v;

        public PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            cedula = v.findViewById(R.id.lblModelo);
            nombre = v.findViewById(R.id.lblPlaca);
            apellido = v.findViewById(R.id.lblMarca);
        }

    }
}
