package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //recyclerview
        recyclerView= findViewById(R.id.reciclador);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new CardAdapter(cargarDatos());
        recyclerView.setAdapter(adapter);
    }

    public List<Card> cargarDatos(){
        ArrayList<Card> listCard= new ArrayList<Card>();

        listCard.add(new Card(R.drawable.akuma_img_round,"Kuqui",12));
        listCard.add(new Card(R.drawable.akuma_img_round,"Donal",126));
        listCard.add(new Card(R.drawable.akuma_img_round,"Donal",126));
        listCard.add(new Card(R.drawable.akuma_img_round,"Martirio",2));
        listCard.add(new Card(R.drawable.akuma_img_round,"Blanquito",312));
        listCard.add(new Card(R.drawable.akuma_img_round,"Coquito",50));

        return listCard;
    }
}