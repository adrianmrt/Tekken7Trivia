package com.example.tekken7trivia.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tekken7trivia.R;
import com.example.tekken7trivia.database.DatabaseViewModel;
import com.example.tekken7trivia.database.RankingUnit;
import com.example.tekken7trivia.database.User;
import com.example.tekken7trivia.main.MainActivity;
import com.example.tekken7trivia.main.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    DatabaseViewModel databaseViewModel;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils utils = new Utils(getApplicationContext());
        getSupportActionBar().hide();
        setContentView(R.layout.activity_score);
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);

        Bundle bundle = getIntent().getExtras();
        score = bundle.getString("score");
        playerName = bundle.getString("playerName");
        _questions = bundle.getParcelableArray("questions");
        timeT = bundle.getString("timeT");
        time = bundle.getString("time");

        scoreText = findViewById(R.id.scoreText);
        replayButton = findViewById(R.id.replayButton);
        backToMenuButton = findViewById(R.id.backToMenuButton);
        playerNameText = findViewById(R.id.nameText);
        timeText = findViewById(R.id.timeScore);

        playerNameText.setText(playerName);
        replayButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
            intent.putExtra("playerName", playerName);
            intent.putExtra("questions", _questions);
            startActivity(intent);
        });

        backToMenuButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        scoreText.setText(score);
        timeText.setText(timeT);
        InsertUserToRanking();
        UpdateUser();
    }

    public void InsertUserToRanking() {
        RankingUnit rankingUnit = new RankingUnit();
        Random rand = new Random();
        rankingUnit.setInnerId(rand.nextInt(999999999));
        rankingUnit.setName(playerName);
        rankingUnit.setScore(Integer.parseInt(score));
        rankingUnit.setTime(Float.parseFloat(time));
        databaseViewModel.InsertRanking(rankingUnit);
    }

    public void UpdateUser() {
        if (sharedPreferences.getBoolean("UserMode", false)) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String currentDate = dateFormat.format(calendar.getTime());
            Handler handler = new Handler();
            Thread t = new Thread() {
                @Override
                public void run() {
                    User user = databaseViewModel.GetUser(playerName);
                    float _score = Float.parseFloat(score);
                    int _numberOfGamesPlayed = user.getNumberOfGamesPlayed() + 1;
                    if (_score > user.getMaxScore()) {
                        databaseViewModel.UpdateUser(playerName, _score, _numberOfGamesPlayed, currentDate);
                    } else {
                        _score = user.getMaxScore();
                        databaseViewModel.UpdateUser(playerName, _score, _numberOfGamesPlayed, currentDate);
                    }
                }
            };
            t.start();
        }
    }
}
