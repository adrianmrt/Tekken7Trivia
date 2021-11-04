package com.example.dadm_p1_albertogarcia_adrianramirez.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;

public class QuestionActivity extends AppCompatActivity {

    String playerName = "";
    int initialScore = 0;


    QuestionStructure[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_question);

        questions = createQuestions();

        Bundle bundle = getIntent().getExtras();
        playerName = bundle.getString("playerName");

        if (savedInstanceState == null) {
            //Fragment manager
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //user Fragment
            //we create a bundle object for passing initial data;
            Bundle TopInitData = new Bundle();
            TopInitData.putInt("initialScore", initialScore);
            TopInitData.putString("playerName", playerName);
            TopInitData.putParcelableArray("questions", questions);
            fragmentTransaction.setReorderingAllowed(true).add(R.id.topLayout, userFragment.class, TopInitData);

            //gameFragment
            Bundle BotInitData = new Bundle();
            BotInitData.putParcelableArray("questions", questions);
            BotInitData.putString("playerName", playerName);
            fragmentTransaction.setReorderingAllowed(true).add(R.id.botLayout, gameFragment.class, BotInitData);

            fragmentTransaction.commit();
        }
    }

    public QuestionStructure[] createQuestions() {
        QuestionStructure[] questionAux = new QuestionStructure[5];

        questionAux[0] = new QuestionStructure(0, 0, new int[]{0, 0, 0, 0},
                "Miguel", "¿Qué personaje es español?",
                new String[]{"Lidia", "Miguel", "Leo"});

        questionAux[1] = new QuestionStructure(0, 1, new int[]{0, R.drawable.devilkazuya_img_round, R.drawable.devilkazumi_img_round, R.drawable.deviljin_img_round},
                "Kazumi", "¿Qué personaje no es de sangre Mishima?",
                new String[]{"Kazuya", "Kazumi", "Jin"});

        questionAux[2] = new QuestionStructure(0, 1, new int[]{0, R.drawable.alisa_img_round, R.drawable.kuma_img_round, R.drawable.king_img_round},
                "King", "¿Quién es humano?",
                new String[]{"Alisa", "Kuma II", "King"});

        questionAux[3] = new QuestionStructure(1, 0, new int[]{R.drawable.steve_img_round, 0, 0, 0},
                "Steve", "¿Cómo se llama este personaje?",
                new String[]{"Steve", "Lars", "Dragunov"});

        questionAux[4] = new QuestionStructure(0, 1, new int[]{0, R.drawable.akuma_img_round, R.drawable.julia_img_round, R.drawable.fahkumram_img_round},
                "Akuma", "¿Qué personaje no pertenece originalmente a la saga Tekken?",
                new String[]{"Akuma", "Julia", "Fahkumram"});

        return questionAux;
    }
}