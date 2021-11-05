package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;

public class LeaderboardFragment extends Fragment {

    TextView rankingText;
    Utils utils;
    public LeaderboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_leaderboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        utils=new Utils(view.getContext());
        rankingText= view.findViewById(R.id.rankingText);
        rankingText.setText(utils.OpenInFile("ranking"));
    }
}