package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.dadm_p1_albertogarcia_adrianramirez.database.Question;
import com.example.dadm_p1_albertogarcia_adrianramirez.game.QuestionActivity;

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
        holder.deleteUser.setOnClickListener(v -> {
            //IMPLEMENTAR EL BORRADO CON EL BOTÓN
            DatabaseViewModel databaseViewModel = new ViewModelProvider((ViewModelStoreOwner) v.getContext()).get(DatabaseViewModel.class);
            Toast.makeText(v.getContext(), "BORRADO: "+holder.nombre.getText(), Toast.LENGTH_SHORT).show();
            databaseViewModel.DeleteUser((String) holder.nombre.getText());
        });

        holder.editUser.setOnClickListener(v -> {

            DatabaseViewModel databaseViewModel = new ViewModelProvider((ViewModelStoreOwner) v.getContext()).get(DatabaseViewModel.class);
            EditText editText = v.getRootView().findViewById(R.id.addUserName);
            if (!TextUtils.isEmpty(editText.getText().toString())) {
                databaseViewModel.UpdateUserName(holder.nombre.getText().toString(),editText.getText().toString());
                editText.setText("");
            }else{
                Toast.makeText(v.getContext(), "Nombre nuevo vacío", Toast.LENGTH_SHORT).show();
            }
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
        public ImageButton editUser;
        public ImageButton editUserAux;

        public UserCardViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.userImgCard);
            nombre = v.findViewById(R.id.userCardName);
            puntuacion = v.findViewById(R.id.userCardScore);
            partidas = v.findViewById(R.id.userCardGamesPlayed);
            ultimaConexion = v.findViewById(R.id.userCardDate);
            play = v.findViewById(R.id.userCardPlayImageButton);
            deleteUser = v.findViewById(R.id.userCardDeleteImageButton);
            editUser= v.findViewById(R.id.userCardEditImageButton);
            editUserAux=editUser;

            play.setOnClickListener(_v -> {
                Toast.makeText(v.getContext(), "SELECCIONADO: " + nombre.getText(), Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = v.getContext().getSharedPreferences("Settings", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("User", nombre.getText().toString()).commit();
                sharedPreferences.edit().putBoolean("UserMode", true).commit();
                Intent intent = new Intent(v.getContext(), QuestionActivity.class);
                v.getContext().startActivity(intent);
            });


        }
    }

    public UserCardAdapter(List<UserCard> lista) {
        this.users = lista;
    }

}
