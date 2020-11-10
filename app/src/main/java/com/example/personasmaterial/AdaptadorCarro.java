package com.example.personasmaterial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdaptadorCarro extends RecyclerView.Adapter<AdaptadorCarro.CarroViewHolder> {

    private ArrayList<Carro> carros;
    private CarroViewHolder.OnCarroClickListener clickListener;

    public AdaptadorCarro(ArrayList<Carro> carros, CarroViewHolder.OnCarroClickListener clickListener)
    {
        this.carros = carros;
        this.clickListener = clickListener;
    }

    @Override
    public AdaptadorCarro.CarroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carro, parent, false);
        return new AdaptadorCarro.CarroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCarro.CarroViewHolder holder, int position) {
        Carro p = carros.get(position);
        holder.foto.setImageResource(p.getFoto());
        holder.modelo.setText(p.getModelo());
        holder.marca.setText(p.getMarca());
        holder.placa.setText(p.getPlaca());
        holder.precio.setText("" + p.getPrecio());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.OnCarroClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView foto;
        private TextView modelo, placa, marca, precio;
        private View v;

        public CarroViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            modelo = v.findViewById(R.id.lblModelo);
            placa = v.findViewById(R.id.lblPlaca);
            marca = v.findViewById(R.id.lblMarca);
            precio = v.findViewById(R.id.lblPrecio);
        }

        public interface OnCarroClickListener{
            void OnCarroClick(Carro c);

        }
    }
}
