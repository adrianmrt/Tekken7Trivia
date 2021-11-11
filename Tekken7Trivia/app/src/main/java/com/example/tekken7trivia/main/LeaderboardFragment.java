package com.example.tekken7trivia.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tekken7trivia.R;
import com.example.tekken7trivia.database.DatabaseViewModel;
import com.example.tekken7trivia.database.RankingUnit;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardFragment extends Fragment {

    TextView rankingText;
    Utils utils;
    String ranking;
    DatabaseViewModel db;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<BoardCard>boardCards;

    public LeaderboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //recyclerview

        db = new ViewModelProvider(this).get(DatabaseViewModel.class);
        boardCards= new ArrayList<BoardCard>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_leaderboard, container, false);
        recyclerView = view.findViewById(R.id.boardRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        db.getAllRanking().observe(getViewLifecycleOwner(), new Observer<List<RankingUnit>>() {
            @Override
            public void onChanged(List<RankingUnit> rankingUnits) {
                boardCards.clear();
                for (RankingUnit r : rankingUnits) {
                    boardCards.add(new BoardCard(r.getName(),r.getScore(),r.getTime()));
                }
                adapter = new BoardCardAdapter(boardCards);
                recyclerView.setAdapter(adapter);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}