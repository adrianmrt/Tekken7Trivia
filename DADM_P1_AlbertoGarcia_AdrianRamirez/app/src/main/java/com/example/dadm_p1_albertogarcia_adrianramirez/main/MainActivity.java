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

        addQuestion("¿Qué personaje es español?", 0, 0, 0, new int[]{},
                new String[]{"Lidia", "Miguel", "Leo"}, "Miguel", "general", 0);

        addQuestion("¿Qué personaje no es de sangre Mishima?", 1, 0, 1, new int[]{0, R.drawable.devilkazuya_img_round, R.drawable.devilkazumi_img_round, R.drawable.deviljin_img_round},
                new String[]{"Kazuya", "Kazumi", "Jin"}, "Kazumi", "general", 0);

        addQuestion("¿Quién es humano?", 2, 0, 1, new int[]{0, R.drawable.alisa_img_round,
                R.drawable.kuma_img_round, R.drawable.king_img_round}, new String[]{"Alisa", "Kuma II", "King"}, "King", "general", 0);
       /*
        HACERLAS BIEN
        addQuestion(1, 0, new int[]{R.drawable.steve_img_round, 0, 0, 0},
                "Steve", "¿Cómo se llama este personaje?",
                new String[]{"Steve", "Lars", "Dragunov"});

        addQuestion(0, 1, new int[]{0, R.drawable.akuma_img_round, R.drawable.julia_img_round, R.drawable.fahkumram_img_round},
                "Akuma", "¿Qué personaje no pertenece originalmente a la saga Tekken?",
                new String[]{"Akuma", "Julia", "Fahkumram"});

        */

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