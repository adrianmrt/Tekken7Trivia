package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.main.Utils;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.Question;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.QuestionDatabase;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.UserDataBase;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static UserDataBase userDataBase;
    public static QuestionDatabase questionDatabase;
    private DatabaseViewModel databaseViewModel;
    Utils utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);

        //createPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, new MainFragment()).commit();
        }

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        utils= new Utils();
        createQuestions();
    }


    @Override
    protected void onResume() {
        super.onResume();
        //playerNameLayout.setErrorEnabled(false);
    }

    public void createQuestions() {

        //Text
        addQuestion("¿Qué personaje es español?", 0, 0, 0, new int[]{},
                new String[]{"Lidia", "Miguel", "Leo"}, "Miguel", "general", 0);

        addQuestion("De los siguientes, ¿Quién pertenece a una serie de TV?", 1, 0, 0, new int[]{},
                new String[]{"Negan", "Bob", "Noctis"}, "Negan", "general", 0);

        addQuestion("Lars encontró a Jin en:", 2, 0, 0, new int[]{},
                new String[]{"China", "USA", "Iraq"}, "Iraq", "general", 0);

        addQuestion("¿Cómo perdió Hwoarang el ojo?", 3, 0, 0, new int[]{},
                new String[]{"En una pelea", "Una enfermedad", "Una explosión"}, "Una explosión", "general", 0);

        addQuestion("¿En qué año se publicó Tekken 7?", 4, 0, 0, new int[]{},
                new String[]{"2012", "2017", "2015"}, "2015", "general", 0);

        addQuestion("¿Qué empresa desarrolló el juego?", 5, 0, 0, new int[]{},
                new String[]{"Bandai Namco", "SEGA", "Koei Tecmo"}, "Bandai Namco", "general", 0);

        //Image
        addQuestion("¿Qué personaje no es de sangre Mishima?", 6, 0, 1, new int[]{0, R.drawable.devilkazuya_img_round, R.drawable.devilkazumi_img_round, R.drawable.deviljin_img_round},
                new String[]{"Kazuya", "Kazumi", "Jin"}, "Kazumi", "general", 0);

        addQuestion("¿Quién es humano?", 7, 0, 1, new int[]{0, R.drawable.alisa_img_round,
                R.drawable.kuma_img_round, R.drawable.king_img_round}, new String[]{"Alisa", "Kuma II", "King"}, "King", "general", 0);

        addQuestion("¿Cómo se llama este personaje?", 8, 1, 0, new int[]{R.drawable.steve_img_round, 0, 0, 0},
                new String[]{"Steve", "Lars", "Dragunov"}, "Steve", "general", 0);

        addQuestion("¿Qué personaje no pertenece originalmente a la saga Tekken?", 9, 0, 0, new int[]{0, R.drawable.akuma_img_round, R.drawable.julia_img_round, R.drawable.fahkumram_img_round},
                new String[]{"Akuma", "Julia", "Fahkumram"}, "Akuma", "general", 0);

        //Video
        addQuestion("¿En qué mapa están combatiendo?", 10, 2, 0, new int[]{},
                new String[]{"Abandoned Temple", "Duomo di Sirio", "Infinite Azure"}, "Duomo di Sirio", "general", 0);

        addQuestion("¿En qué mapa están combatiendo?", 11, 2, 0, new int[]{},
                new String[]{"Forgotten Realm", "Brimstone and Fire", "Kinder Gym"}, "Brimstone and Fire", "general", 0);

        addQuestion("¿En qué mapa están combatiendo?", 12, 2, 0, new int[]{},
                new String[]{"Devil's Pit", "Mishima Building", "Jungle Outpost"}, "Jungle Outpost", "general", 0);

        addQuestion("¿En qué mapa están combatiendo?", 13, 2, 0, new int[]{},
                new String[]{"Arctic Snowfall", "Mishima Dojo", "Last Day on Earth"}, "Last Day on Earth", "general", 0);

        addQuestion("¿En qué mapa están combatiendo?", 14, 2, 0, new int[]{},
                new String[]{"Mishima Building", "Twilight Conflict", "Precipice of Fate"}, "Twilight Conflict", "general", 0);

        addQuestion("¿En qué mapa están combatiendo?", 15, 2, 0, new int[]{},
                new String[]{"Howard Estate", "Vermilion Gates", "Violet Systems"}, "Violet Systems", "general", 0);

        addQuestion("¿En qué mapa están combatiendo?", 16, 2, 0, new int[]{},
                new String[]{"Arena", "Geometric Plane", "Souq"}, "Arena", "general", 0);

        addQuestion("¿En qué mapa están combatiendo?", 17, 2, 0, new int[]{},
                new String[]{"Mishima Building", "Hammerhead", "Dragon's Nest"}, "Mishima Building", "general", 0);

        addQuestion("¿En qué mapa están combatiendo?", 18, 2, 0, new int[]{},
                new String[]{"Twilight Conflict", "Island Paradise", "Kinder Gym"}, "Twilight Conflict", "general", 0);

        addQuestion("¿En qué mapa están combatiendo?", 19, 2, 0, new int[]{},
                new String[]{"Devil's Pit", "Dragon's Nest", "Forgotten Realm"}, "Dragon's Nest", "general", 0);
    }

    void addQuestion(String questionText, int qId, int qT, int aT, int[] images, String[] answers, String answer, String qB, int mId) {
        Question question = new Question();
        question.set_question(questionText);
        question.setQuestionId(qId);
        question.set_possibleAnswers(Utils.createStringList(answers));
        question.set_images(Utils.createStringList(images));
        question.set_questionType(qT);
        question.set_answerType(aT);
        question.set_answer(answer);
        question.set_questionBlock(qB);
        question.set_multimediaFileId(mId);
        databaseViewModel.InsertQuestion(question);
    }

}