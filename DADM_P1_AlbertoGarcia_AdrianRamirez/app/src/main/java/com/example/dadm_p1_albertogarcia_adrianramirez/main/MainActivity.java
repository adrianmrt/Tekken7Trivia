package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.QuestionDatabase;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.UserDataBase;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static UserDataBase userDataBase;
    public static QuestionDatabase questionDatabase;

    private DatabaseViewModel databaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        userDataBase = Room.databaseBuilder(getApplicationContext(), UserDataBase.class, "userdb").allowMainThreadQueries().build();
        //questionDatabase= Room.databaseBuilder(getApplicationContext(), QuestionDatabase.class, "questiondb").allowMainThreadQueries().build();
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, new MainFragment()).commit();
        }

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //playerNameLayout.setErrorEnabled(false);
    }


}