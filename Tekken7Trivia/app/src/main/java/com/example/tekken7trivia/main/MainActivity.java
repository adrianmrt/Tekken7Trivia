package com.example.tekken7trivia.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.tekken7trivia.R;
import com.example.tekken7trivia.database.DatabaseViewModel;
import com.example.tekken7trivia.database.Question;
import com.example.tekken7trivia.database.QuestionDatabase;
import com.example.tekken7trivia.database.UserDataBase;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static UserDataBase userDataBase;
    public static QuestionDatabase questionDatabase;
    private DatabaseViewModel databaseViewModel;
    Utils utils;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);

        //createPreferences
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("UserMode",false).commit();
        sharedPreferences.edit().putInt("numberOfQuestions",5).commit();
        sharedPreferences.edit().putString("blockType","Mixtas").commit();

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
        addQuestion("??Qu?? personaje es espa??ol?", 0, 0, 0, new int[]{},
                new String[]{"Lidia", "Miguel", "Leo"}, "Miguel", "Texto e imagen", "");

        addQuestion("De los siguientes, ??Qui??n pertenece a una serie de TV?", 1, 0, 0, new int[]{},
                new String[]{"Negan", "Bob", "Noctis"}, "Negan", "Texto e imagen", "");

        addQuestion("Lars encontr?? a Jin en:", 2, 0, 0, new int[]{},
                new String[]{"China", "USA", "Iraq"}, "Iraq", "Texto e imagen", "");

        addQuestion("??C??mo perdi?? Hwoarang el ojo?", 3, 0, 0, new int[]{},
                new String[]{"En una pelea", "Una enfermedad", "Una explosi??n"}, "Una explosi??n", "Texto e imagen", "");

        addQuestion("??En qu?? a??o se public?? Tekken 7?", 4, 0, 0, new int[]{},
                new String[]{"2012", "2017", "2015"}, "2015", "Texto e imagen", "");

        addQuestion("??Qu?? empresa desarroll?? el juego?", 5, 0, 0, new int[]{},
                new String[]{"Bandai Namco", "SEGA", "Koei Tecmo"}, "Bandai Namco", "Texto e imagen", "");

        //Image
        addQuestion("??Qu?? personaje no es de sangre Mishima?", 6, 0, 1, new int[]{0, R.drawable.devilkazuya_img_round, R.drawable.devilkazumi_img_round, R.drawable.deviljin_img_round},
                new String[]{"Kazuya", "Kazumi", "Jin"}, "Kazumi", "Texto e imagen", "");

        addQuestion("??Qui??n es humano?", 7, 0, 1, new int[]{0, R.drawable.alisa_img_round,
                R.drawable.kuma_img_round, R.drawable.king_img_round}, new String[]{"Alisa", "Kuma II", "King"}, "King", "Texto e imagen", "");

        addQuestion("??C??mo se llama este personaje?", 8, 1, 0, new int[]{R.drawable.steve_img_round, 0, 0, 0},
                new String[]{"Steve", "Lars", "Dragunov"}, "Steve", "Texto e imagen", "");

        addQuestion("??Qu?? personaje no pertenece originalmente a la saga Tekken?", 9, 0, 0, new int[]{0, R.drawable.akuma_img_round, R.drawable.julia_img_round, R.drawable.fahkumram_img_round},
                new String[]{"Akuma", "Julia", "Fahkumram"}, "Akuma", "Texto e imagen", "");

        //Video
        addQuestion("??En qu?? mapa est??n combatiendo?", 10, 2, 0, new int[]{},
                new String[]{"Abandoned Temple", "Duomo di Sirio", "Infinite Azure"}, "Duomo di Sirio", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.duomo_di_sirio_video);

        addQuestion("??En qu?? mapa est??n combatiendo?", 11, 2, 0, new int[]{},
                new String[]{"Forgotten Realm", "Brimstone and Fire", "Kinder Gym"}, "Brimstone and Fire", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.brimstone_and_fire_video);

        addQuestion("??En qu?? mapa est??n combatiendo?", 12, 2, 0, new int[]{},
                new String[]{"Devil's Pit", "Mishima Building", "Jungle Outpost"}, "Jungle Outpost", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.jungle_outpost_video);

        addQuestion("??En qu?? mapa est??n combatiendo?", 13, 2, 0, new int[]{},
                new String[]{"Arctic Snowfall", "Mishima Dojo", "Last Day on Earth"}, "Last Day on Earth", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.last_day_on_earth_video);

        addQuestion("??En qu?? mapa est??n combatiendo?", 14, 2, 0, new int[]{},
                new String[]{"Mishima Building", "Twilight Conflict", "Precipice of Fate"}, "Twilight Conflict", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.twilight_conflict_sunset_video);

        addQuestion("??En qu?? mapa est??n combatiendo?", 15, 2, 0, new int[]{},
                new String[]{"Howard Estate", "Vermilion Gates", "Violet Systems"}, "Violet Systems", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.violet_systems_video);

        addQuestion("??En qu?? mapa est??n combatiendo?", 16, 2, 0, new int[]{},
                new String[]{"Arena", "Geometric Plane", "Souq"}, "Arena", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.arena_video);

        addQuestion("??En qu?? mapa est??n combatiendo?", 17, 2, 0, new int[]{},
                new String[]{"Mishima Building", "Hammerhead", "Dragon's Nest"}, "Mishima Building", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.mishima_building_video);

        addQuestion("??En qu?? mapa est??n combatiendo?", 18, 2, 0, new int[]{},
                new String[]{"Twilight Conflict", "Island Paradise", "Kinder Gym"}, "Twilight Conflict", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.twilight_conflict_day_video);

        addQuestion("??En qu?? mapa est??n combatiendo?", 19, 2, 0, new int[]{},
                new String[]{"Devil's Pit", "Dragon's Nest", "Forgotten Realm"}, "Dragon's Nest", "V??deo", "android.resource://" + getPackageName() + "/" +R.raw.dragons_nest_video);
    }

    void addQuestion(String questionText, int qId, int qT, int aT, int[] images, String[] answers, String answer, String qB, String mId) {
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