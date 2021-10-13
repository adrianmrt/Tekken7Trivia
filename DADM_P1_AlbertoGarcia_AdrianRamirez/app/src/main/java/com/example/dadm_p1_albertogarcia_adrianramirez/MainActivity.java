package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout playerNameLayout;
    EditText playerNameInput;
    Button playButton;

    QuestionStructure[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton);
        playerNameInput = findViewById(R.id.playerNameInput);
        playerNameLayout = findViewById(R.id.playerNameInputLayout);

        questions = createQuestions();

        playButton.setOnClickListener(v -> {
            String localPlayerName = playerNameInput.getText().toString();

            if(TextUtils.isEmpty(localPlayerName)){
                playerNameLayout.setError("Campo vacío");
                playerNameLayout.setErrorEnabled(true);
            } else {
                Intent intent = new Intent(getApplicationContext(),QuestionActivity.class);
                intent.putExtra("playerName", localPlayerName);
                intent.putExtra("questions", questions);
                startActivity(intent);
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    protected void onResume() {
        super.onResume();

        playerNameLayout.setErrorEnabled(false);
    }

    public QuestionStructure[] createQuestions(){
        QuestionStructure[] questionAux = new QuestionStructure[2];
        questionAux[0] = new QuestionStructure(0,1,2);
        questionAux[1] = new QuestionStructure(1,0,3);
        return questionAux;
    }

}