package com.example.dadm_p1_albertogarcia_adrianramirez.game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.main.MainActivity;
import com.example.dadm_p1_albertogarcia_adrianramirez.main.Utils;

public class ScoreActivity extends AppCompatActivity {

    String score;
    String playerName;
    String time;
    TextView playerNameText;
    TextView scoreText;
    TextView timeText;
    Button replayButton;
    Button backToMenuButton;
    Parcelable[] _questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils utils= new Utils(getApplicationContext());
        getSupportActionBar().hide();
        setContentView(R.layout.activity_score);

        Bundle bundle = getIntent().getExtras();
        score = bundle.getString("score");
        playerName = bundle.getString("playerName");
        _questions= bundle.getParcelableArray("questions");
        time= bundle.getString("time");

        scoreText = findViewById(R.id.scoreText);
        replayButton = findViewById(R.id.replayButton);
        backToMenuButton = findViewById(R.id.backToMenuButton);
        playerNameText = findViewById(R.id.nameText);
        timeText= findViewById(R.id.timeScore);

        playerNameText.setText(playerName);
        replayButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),QuestionActivity.class);
            intent.putExtra("playerName", playerName);
            intent.putExtra("questions",_questions);
            startActivity(intent);
        });

        backToMenuButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        scoreText.setText(score);
        timeText.setText(time);

        utils.OpenOutFile("ranking",playerName+" "+score+" "+time);

    }
}
