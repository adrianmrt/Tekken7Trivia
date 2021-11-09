package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;

import java.util.List;

public class BoardCardAdapter extends RecyclerView.Adapter<BoardCardAdapter.CardViewHolder>{
    public List<BoardCard> items;

    @NonNull
    @Override
    public BoardCardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_card, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.nombre.setText("Nombre: "+items.get(position).getNombre());
        holder.puntuacion.setText("Puntuación: "+Integer.toString(items.get(position).getScore()));
        holder.timeText.setText("Tiempo: "+Float.toString(items.get(position).getTime()));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;
        public TextView puntuacion;
        public TextView timeText;

        public CardViewHolder(View v) {
            super(v);
            nombre = v.findViewById(R.id.boardName);
            puntuacion = v.findViewById(R.id.boardScore);
            timeText= v.findViewById(R.id.boardTime);
        }
    }
    public BoardCardAdapter(List<BoardCard> lista) {
        this.items = lista;
    }


}
