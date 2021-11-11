package com.example.tekken7trivia.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.tekken7trivia.R;
import com.example.tekken7trivia.database.DatabaseViewModel;
import com.example.tekken7trivia.database.QuestionDAO;

public class QuestionActivity extends AppCompatActivity {

    String playerName = "";
    int initialScore = 0;

    QuestionDAO questionDAO;
    DatabaseViewModel databaseViewModel;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_question);
        sharedPreferences=getSharedPreferences("Settings", Context.MODE_PRIVATE);
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);

        Bundle bundle = getIntent().getExtras();
        if(sharedPreferences.getBoolean("UserMode",false)){
            playerName= sharedPreferences.getString("User","User");
        }else{
            playerName = bundle.getString("playerName");
        }

        if (savedInstanceState == null) {
            //Fragment manager
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //user Fragment
            //we create a bundle object for passing initial data;
            Bundle TopInitData = new Bundle();
            TopInitData.putInt("initialScore", initialScore);
            TopInitData.putString("playerName", playerName);

            fragmentTransaction.setReorderingAllowed(true).add(R.id.topLayout, UserFragment.class, TopInitData);
            //gameFragment
            Bundle BotInitData = new Bundle();
            BotInitData.putString("playerName", playerName);
            fragmentTransaction.setReorderingAllowed(true).add(R.id.botLayout, GameFragment.class, BotInitData);

            fragmentTransaction.commit();
        }
    }
}