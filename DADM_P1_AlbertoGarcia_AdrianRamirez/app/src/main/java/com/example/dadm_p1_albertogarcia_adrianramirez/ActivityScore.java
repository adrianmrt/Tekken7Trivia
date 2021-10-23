package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityScore extends AppCompatActivity {

    String score;
    String playerName;
    TextView playerNameText;
    TextView scoreText;
    Button replayButton;
    Button backToMenuButton;
    Parcelable[] _questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_score);

        Bundle bundle = getIntent().getExtras();
        score = bundle.getString("score");
        playerName = bundle.getString("playerName");
        _questions= bundle.getParcelableArray("questions");

        scoreText = findViewById(R.id.scoreText);
        replayButton = findViewById(R.id.replayButton);
        backToMenuButton = findViewById(R.id.backToMenuButton);
        playerNameText = findViewById(R.id.nameText);

        playerNameText.setText(playerName);
        replayButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ActivityQuestion.class);
            intent.putExtra("playerName", playerName);
            intent.putExtra("questions",_questions);
            startActivity(intent);
        });

        backToMenuButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
            startActivity(intent);
        });

        scoreText.setText(score);
    }
}
