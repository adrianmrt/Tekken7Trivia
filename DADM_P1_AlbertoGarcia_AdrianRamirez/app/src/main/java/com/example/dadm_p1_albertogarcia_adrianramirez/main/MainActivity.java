package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.dadm_p1_albertogarcia_adrianramirez.R;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.Question;
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
        //userDataBase = Room.databaseBuilder(getApplicationContext(), UserDataBase.class, "userdb").allowMainThreadQueries().build();
        //questionDatabase= Room.databaseBuilder(getApplicationContext(), QuestionDatabase.class, "questiondb").allowMainThreadQueries().build();
        databaseViewModel = new ViewModelProvider(this).get(DatabaseViewModel.class);

        createQuestions();

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, new MainFragment()).commit();
        }

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    private void createQuestions() {

        Question question= new Question();
        question.set_question("¿Cómo se llama este personaje?");
        question.setQuestionId(19);
        question.set_possibleAnswers(Utils.createStringList(new String[]{"aaa","b"}));
        question.set_images(Utils.createBitmapList(new int[]{R.drawable.steve_img_round},getApplicationContext()));
        question.set_questionType(1);
        question.set_answerType(0);
        question.set_answer("Steve");
        databaseViewModel.InsertQuestion(question);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //playerNameLayout.setErrorEnabled(false);
    }


}