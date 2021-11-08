package com.example.dadm_p1_albertogarcia_adrianramirez.game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.RankingUnit;
import com.example.dadm_p1_albertogarcia_adrianramirez.main.MainActivity;
import com.example.dadm_p1_albertogarcia_adrianramirez.Utils;

import java.util.Random;

public class ScoreActivity extends AppCompatActivity {

    String score;
    String playerName;
    String timeT;
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
        timeT= bundle.getString("timeT");
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
        timeText.setText(timeT);

        DatabaseViewModel db= new ViewModelProvider(this).get(DatabaseViewModel.class);
        RankingUnit rankingUnit= new RankingUnit();
        Random rand= new Random();
        rankingUnit.setInnerId(rand.nextInt(999999999));
        rankingUnit.setName(playerName);
        rankingUnit.setScore(Integer.parseInt(score));
        rankingUnit.setTime(Float.parseFloat(time));
        db.InsertRanking(rankingUnit);
    }
}
