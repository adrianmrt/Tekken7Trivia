package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.main.Utils;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.RankingUnit;

import java.util.List;

public class LeaderboardFragment extends Fragment {

    TextView rankingText;
    Utils utils;
    String ranking;
    DatabaseViewModel db;

    public LeaderboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_leaderboard, container, false);
        db = new ViewModelProvider(this).get(DatabaseViewModel.class);
        db.getAllRanking().observe(getViewLifecycleOwner(), new Observer<List<RankingUnit>>() {
            @Override
            public void onChanged(List<RankingUnit> rankingUnits) {
                ranking = "";
                for (RankingUnit r : rankingUnits) {
                    String name = r.getName();
                    String score = Integer.toString(r.getScore());
                    String time = Float.toString(r.getTime());
                    ranking = ranking + "Nombre: " + name + " Puntuación: " + score + "Tiempo: " + time + "\n";
                }
                rankingText.setText(ranking);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rankingText = view.findViewById(R.id.rankingText);
        ranking="";
    }
}