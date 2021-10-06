package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    //explanation
    /*
    We decide to use shared Preferences in order to maintain and store data when the activity restarts.
    We use private mode access in order to avoid other apps accessing the preferences.
     */


    int typeOfQuestion; //define types


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //Fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        userFragment fragmentTop= new userFragment();
        gameFragment fragmentBot = new gameFragment();

        fragmentTransaction.add(R.id.topLayout, fragmentTop);
        fragmentTransaction.add(R.id.botLayout, fragmentBot);
        fragmentTransaction.commit();


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