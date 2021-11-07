package com.example.dadm_p1_albertogarcia_adrianramirez.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.QuestionDAO;

public class QuestionActivity extends AppCompatActivity {

    String playerName = "";
    int initialScore = 0;

    QuestionDAO questionDAO;
    DatabaseViewModel databaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_question);

        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);

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
            fragmentTransaction.setReorderingAllowed(true).add(R.id.topLayout, userFragment.class, TopInitData);

            //gameFragment
            Bundle BotInitData = new Bundle();
            BotInitData.putString("playerName", playerName);
            fragmentTransaction.setReorderingAllowed(true).add(R.id.botLayout, gameFragment.class, BotInitData);

            fragmentTransaction.commit();
        }
    }
}