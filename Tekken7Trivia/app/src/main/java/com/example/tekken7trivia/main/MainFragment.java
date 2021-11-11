package com.example.tekken7trivia.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.tekken7trivia.game.QuestionActivity;
import com.example.tekken7trivia.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainFragment extends Fragment {

    TextInputLayout playerNameLayout;
    EditText playerNameInput;
    Button playButton;
    Button changeMode;
    ImageButton infoButton;
    ImageButton configButton;
    ImageButton userButton;
    ImageButton leaderboardButton;
    View rootView;

    SharedPreferences sharedPreferences;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        sharedPreferences = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);

        playButton = rootView.findViewById(R.id.playButton);
        playerNameInput = rootView.findViewById(R.id.playerNameInput);
        playerNameLayout = rootView.findViewById(R.id.playerNameInputLayout);

        infoButton = rootView.findViewById(R.id.infoButton);
        configButton = rootView.findViewById(R.id.ConfigButton);
        userButton = rootView.findViewById(R.id.UserButton);
        leaderboardButton = rootView.findViewById(R.id.LeaderboardButton);
        SetListeners();

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void SetListeners() {
        playButton.setOnClickListener(v -> {
            String localPlayerName = playerNameInput.getText().toString();

            if (TextUtils.isEmpty(localPlayerName)) {
                playerNameLayout.setError("Campo vacío");
                playerNameLayout.setErrorEnabled(true);
            } else {
                sharedPreferences.edit().putBoolean("UserMode", false).commit();
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                intent.putExtra("playerName", localPlayerName);
                startActivity(intent);
            }
        });

        configButton.setOnClickListener(v -> {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new MainConfigFragment()).addToBackStack(null).commit();
        });

        userButton.setOnClickListener(v -> {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new MainUserFragment()).addToBackStack(null).commit();
        });

        leaderboardButton.setOnClickListener(v -> {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new LeaderboardFragment()).addToBackStack(null).commit();
        });

        infoButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), InfoActivity.class);
            startActivity(intent);
        });

    }
}