package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    private String _score;
    private String _playerName;
    private TextView _playerNameText;
    private TextView _scoreText;
    private Button _replayButton;
    private Button _backToMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle bundle = getIntent().getExtras();
        _score = bundle.getString("score");
        _playerName = bundle.getString("playerName");

        _scoreText = findViewById(R.id.scoreText);
        _replayButton = findViewById(R.id.replayButton);
        _backToMenuButton = findViewById(R.id.backToMenuButton);
        _playerNameText = findViewById(R.id.nameText);

        _playerNameText.setText(_playerName);

        _replayButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),QuestionActivity.class);
            intent.putExtra("playerName", _playerName);
            startActivity(intent);
        });

        _backToMenuButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("playerName", _playerName);
            startActivity(intent);
        });

        _scoreText.setText(_score);
    }
}
