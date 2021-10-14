package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Parcelable;

public class QuestionActivity extends AppCompatActivity {

    String playerName = "";
    int initialScore = 0;
    int typeOfQuestion; //define types

    Parcelable[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_question);

        Bundle bundle = getIntent().getExtras();
        playerName = bundle.getString("playerName");
        questions = bundle.getParcelableArray("questions");

        if (savedInstanceState == null) {
            //Fragment manager
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //user Fragment
            //we create a bundle object for passing initial data;
            Bundle TopInitData = new Bundle();
            TopInitData.putInt("initialScore", initialScore);
            TopInitData.putString("playerName", playerName);
            fragmentTransaction.setReorderingAllowed(true).add(R.id.topLayout, userFragment.class, TopInitData);

            //gameFragment
            Bundle BotInitData = new Bundle();
            BotInitData.putParcelableArray("questions", questions);
            BotInitData.putString("playerName", playerName);
            fragmentTransaction.setReorderingAllowed(true).add(R.id.botLayout, gameFragment.class, BotInitData);

            fragmentTransaction.commit();
        }
    }
}





/*
    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("QuestionPrefs", MODE_PRIVATE).edit();
    }

    public void nextQuestion(View v){
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("QuestionPrefs", MODE_PRIVATE).edit();
        updatePoints(editor,points);
        editor.commit();
    }

    private void updatePoints(SharedPreferences.Editor editor, int numberPoints){
        editor.putInt("points", numberPoints);
    }
    */