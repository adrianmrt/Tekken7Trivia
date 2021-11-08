package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;

import java.util.Date;
import java.util.List;

public class UserCardAdapter extends RecyclerView.Adapter<UserCardAdapter.UserCardViewHolder> {
    public List<UserCard> users;

    @NonNull
    @Override
    public UserCardAdapter.UserCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card, parent, false);
        return new UserCardAdapter.UserCardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserCardAdapter.UserCardViewHolder holder, int position) {
        holder.imagen.setImageResource(users.get(position).getImagen());
        holder.nombre.setText(users.get(position).getNombre());
        holder.puntuacion.setText(String.valueOf(users.get(position).getPuntuacion()));
        holder.partidas.setText(String.valueOf(users.get(position).getPartidas()));
        holder.ultimaConexion.setText(users.get(position).getUltimaConexion());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserCardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView puntuacion;
        public TextView partidas;
        public TextView ultimaConexion;

        public UserCardViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.userImgCard);
            nombre = v.findViewById(R.id.userCardName);
            puntuacion = v.findViewById(R.id.userCardScore);
            partidas = v.findViewById(R.id.userCardGamesPlayed);
            ultimaConexion = v.findViewById(R.id.userCardDate);
        }
    }

    public UserCardAdapter(List<UserCard> lista) {
        this.users = lista;
    }

}
