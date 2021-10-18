package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    String score;
    String playerName;
    TextView playerNameText;
    TextView scoreText;
    Button replayButton;
    Button backToMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle bundle = getIntent().getExtras();
        score = bundle.getString("score");
        playerName = bundle.getString("playerName");

        scoreText = findViewById(R.id.scoreText);
        replayButton = findViewById(R.id.replayButton);
        backToMenuButton = findViewById(R.id.backToMenuButton);
        playerNameText = findViewById(R.id.nameText);

        playerNameText.setText(playerName);

        replayButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),QuestionActivity.class);
            intent.putExtra("playerName", playerName);
            startActivity(intent);
        });

        backToMenuButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

        scoreText.setText(score);
    }
}
