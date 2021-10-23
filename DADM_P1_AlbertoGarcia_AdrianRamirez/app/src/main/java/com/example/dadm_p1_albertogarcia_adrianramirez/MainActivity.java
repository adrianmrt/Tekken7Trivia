package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Dao;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputLayout playerNameLayout;
    EditText playerNameInput;
    Button playButton;
    ImageButton infoButton;
    ToggleButton showActionBar;
    QuestionStructure[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton);
        playerNameInput = findViewById(R.id.playerNameInput);
        playerNameLayout = findViewById(R.id.playerNameInputLayout);
        infoButton = findViewById(R.id.infoButton);
        showActionBar = findViewById(R.id.toggleActionBar);

        //questions = createQuestions();
        AppDatabase db = AppDatabase.getDatabase(getApplicationContext());

        playButton.setOnClickListener(v -> {
            String localPlayerName = playerNameInput.getText().toString();

            if (TextUtils.isEmpty(localPlayerName)) {
                playerNameLayout.setError("Campo vacío");
                playerNameLayout.setErrorEnabled(true);
            } else {
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                intent.putExtra("playerName", localPlayerName);
                //intent.putExtra("questions", questions);
                startActivity(intent);
            }
        });

        infoButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
            startActivity(intent);
        });

        showActionBar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                getSupportActionBar().show();
            } else {
                getSupportActionBar().hide();
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    @Override
    protected void onResume() {
        super.onResume();
        playerNameLayout.setErrorEnabled(false);
    }
}