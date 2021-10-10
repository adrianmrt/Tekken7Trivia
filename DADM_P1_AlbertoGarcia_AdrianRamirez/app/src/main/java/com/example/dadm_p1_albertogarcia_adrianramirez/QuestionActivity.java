package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class QuestionActivity extends AppCompatActivity {

    int initialPoints = 0;
    String playerName = "";
    int typeOfQuestion; //define types


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Bundle bundle = getIntent().getExtras();
        playerName = bundle.getString("playerName");

        if (savedInstanceState == null) {
            //Fragment manager
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //user Fragment
            //we create a bundle object for passing initial data;
            Bundle initialData = new Bundle();
            initialData.putInt("initialPoints", initialPoints);
            initialData.putString("playerName", playerName);
            fragmentTransaction.setReorderingAllowed(true).add(R.id.topLayout, userFragment.class, initialData);

            //gameFragment
            fragmentTransaction.setReorderingAllowed(true).add(R.id.botLayout, gameFragment.class, null);

            //questionFragment
            fragmentTransaction.setReorderingAllowed(true).add(R.id.answerLayout, questionFragment.class, null);

            fragmentTransaction.commit();
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



}