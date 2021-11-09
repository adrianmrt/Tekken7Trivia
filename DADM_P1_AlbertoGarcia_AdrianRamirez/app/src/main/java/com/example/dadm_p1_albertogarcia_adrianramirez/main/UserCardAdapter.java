package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;

import java.security.PublicKey;
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
        holder.play.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "SELECCIONADO: "+holder.nombre.getText(), Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences= v.getContext().getSharedPreferences("Settings", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("User", holder.nombre.getText().toString()).commit();
            sharedPreferences.edit().putBoolean("UserMode", true).commit();
        });
        holder.deleteUser.setOnClickListener(v -> {
            //IMPLEMENTAR EL BORRADO CON EL BOTÓN
            DatabaseViewModel databaseViewModel = new ViewModelProvider((ViewModelStoreOwner) v.getContext()).get(DatabaseViewModel.class);
            Toast.makeText(v.getContext(), "BORRADO: "+holder.nombre.getText(), Toast.LENGTH_SHORT).show();
            databaseViewModel.DeleteUser((String) holder.nombre.getText());
        });
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
        public ImageButton play;
        public ImageButton deleteUser;

        public UserCardViewHolder(View _v) {
            super(_v);
            imagen = _v.findViewById(R.id.userImgCard);
            nombre = _v.findViewById(R.id.userCardName);
            puntuacion = _v.findViewById(R.id.userCardScore);
            partidas = _v.findViewById(R.id.userCardGamesPlayed);
            ultimaConexion = _v.findViewById(R.id.userCardDate);
            play= _v.findViewById(R.id.userCardPlayImageButton);
            deleteUser=_v.findViewById(R.id.userCardDeleteImageButton);
        }
    }

    public UserCardAdapter(List<UserCard> lista) {
        this.users = lista;
    }

}
