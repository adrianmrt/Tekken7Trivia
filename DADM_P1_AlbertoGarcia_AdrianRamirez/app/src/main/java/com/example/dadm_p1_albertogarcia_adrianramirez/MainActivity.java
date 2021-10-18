package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton);
        playerNameInput = findViewById(R.id.playerNameInput);
        playerNameLayout = findViewById(R.id.playerNameInputLayout);

        questions = createQuestions();

        playButton.setOnClickListener(v -> {
            String localPlayerName = playerNameInput.getText().toString();

            if (TextUtils.isEmpty(localPlayerName)) {
                playerNameLayout.setError("Campo vacío");
                playerNameLayout.setErrorEnabled(true);
            } else {
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
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

    public QuestionStructure[] createQuestions() {
        QuestionStructure[] questionAux = new QuestionStructure[5];

        questionAux[0] = new QuestionStructure(0, 0, new int[]{0,0,0,0},
                "Miguel", "¿Qué personaje es español?",
                new String[]{"Lidia", "Miguel", "Leo"});

        questionAux[1] = new QuestionStructure(0, 1, new int[]{0, R.drawable.devilkazuya_img_round, R.drawable.devilkazumi_img_round, R.drawable.deviljin_img_round},
                "Kazumi", "¿Qué personaje no es de sangre Mishima?",
                new String[]{"Kazuya", "Kazumi", "Jin"});

        questionAux[2] = new QuestionStructure(0, 1, new int[]{0, R.drawable.alisa_img_round, R.drawable.kuma_img_round, R.drawable.king_img_round},
                "King", "¿Quién es humano?",
                new String[]{"Alisa", "Kuma", "King"});

        questionAux[3] = new QuestionStructure(1, 0, new int[]{R.drawable.steve_img_round, 0, 0, 0},
                "Steve", "¿Cómo se llama este personaje?",
                new String[]{"Steve", "Lars", "Dragunov"});

        questionAux[4] = new QuestionStructure(0, 1, new int[]{0, R.drawable.akuma_img_round, R.drawable.julia_img_round, R.drawable.fahkumram_img_round},
                "Akuma", "¿Qué personaje no pertenece originalmente a la saga Tekken?",
                new String[]{"Akuma", "Julia", "Fahkumram"});

        return questionAux;
    }
}