package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    //class data
    int points;
    String playerName;

    //layout references
    TextView pointsV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        points = 0;

        //set initial points and player name
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("QuestionPrefs", MODE_PRIVATE).edit();
        editor.putString("name",playerName);
        updatePoints(editor,points);
        editor.apply();

        //set screen object
        setLayout();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("QuestionPrefs", MODE_PRIVATE).edit();

        //set screen object
        setLayout();
    }

    public void nextQuestion(View v){
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("QuestionPrefs", MODE_PRIVATE).edit();
        updatePoints(editor,points);
        editor.commit();
    }

    private void updatePoints(SharedPreferences.Editor editor, int numberPoints){
        editor.putInt("points", numberPoints);
    }

    private void setLayout(){
        pointsV=findViewById(R.id.pointsV);
        pointsV.setText(points);
    }
}