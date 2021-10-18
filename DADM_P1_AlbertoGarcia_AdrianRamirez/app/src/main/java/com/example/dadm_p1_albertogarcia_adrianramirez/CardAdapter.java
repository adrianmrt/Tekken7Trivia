package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{

    public List<Card> items;

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
    public ImageView imagen;
    public TextView nombre;
    public TextView pais;

    public CardViewHolder(View v){
        super(v);
        imagen= v.findViewById(R.id.imgCard);
        nombre= v.findViewById(R.id.nombre);
        pais= v.findViewById(R.id.pais);
    }
}

    public CardAdapter(List<Card> lista){
        this.items=lista;
    }

}
