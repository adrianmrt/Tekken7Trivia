package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;
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

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "questionsDatabase").build();
    }

    @Override
    protected void onResume() {
        super.onResume();

        playerNameLayout.setErrorEnabled(false);
    }

    public QuestionStructure[] createQuestions() {
        QuestionStructure[] questionAux = new QuestionStructure[5];

        questionAux[0] = new QuestionStructure(0, 0, createBitmapList(new int[]{}),
                "Miguel", "¿Qué personaje es español?",
                createStringList(new String[]{"Lidia", "Miguel", "Leo"}));

        questionAux[1] = new QuestionStructure(0, 1, createBitmapList(new int[]{R.drawable.devilkazuya_img_round, R.drawable.devilkazumi_img_round, R.drawable.deviljin_img_round}),
                "Kazumi", "¿Qué personaje no es de sangre Mishima?",
                createStringList(new String[]{"Kazuya", "Kazumi", "Jin"}));

        questionAux[2] = new QuestionStructure(0, 1, createBitmapList(new int[]{R.drawable.alisa_img_round, R.drawable.kuma_img_round, R.drawable.king_img_round}),
                "King", "¿Quién es humano?",
                createStringList(new String[]{"Alisa", "Kuma II", "King"}));

        questionAux[3] = new QuestionStructure(1, 0, createBitmapList(new int[]{R.drawable.steve_img_round}),
                "Steve", "¿Cómo se llama este personaje?",
                createStringList(new String[]{"Steve", "Lars", "Dragunov"}));

        questionAux[4] = new QuestionStructure(0, 1, createBitmapList(new int[]{0, R.drawable.akuma_img_round, R.drawable.julia_img_round, R.drawable.fahkumram_img_round}),
                "Akuma", "¿Qué personaje no pertenece originalmente a la saga Tekken?",
                createStringList(new String[]{"Akuma", "Julia", "Fahkumram"}));

        return questionAux;
    }

    public ArrayList createBitmapList(int[] elements){
        ArrayList<Bitmap> list= new ArrayList<>();
        for(int i=0;i<elements.length;i++){
            list.add(BitmapFactory.decodeResource(getResources(),elements[i]));
        }
        return list;
    }

    public ArrayList createStringList(String[] elements){
        ArrayList<String> list= new ArrayList<>();
        for(int i=0;i<elements.length;i++){
            list.add(elements[i]);
        }
        return list;
    }
}