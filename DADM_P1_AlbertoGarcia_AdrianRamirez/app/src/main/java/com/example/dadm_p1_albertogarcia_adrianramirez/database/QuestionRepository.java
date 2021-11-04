package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.dadm_p1_albertogarcia_adrianramirez.main.Utils;

import java.util.List;
import com.example.dadm_p1_albertogarcia_adrianramirez.R;

public class QuestionRepository {

    private QuestionDAO questionDAO;
    Utils utils;
    public QuestionRepository(Application application) {
        QuestionDatabase questionDatabase= Room.databaseBuilder(application.getApplicationContext(),
                QuestionDatabase.class, "questiondb").build();
        questionDAO=questionDatabase.questionDAO();

        Question question= new Question();
        question.set_question("¿Cómo se llama este personaje?");
        question.setQuestionId(4);
        question.set_possibleAnswers(Utils.createStringList(new String[]{"aaa","b"}));
        question.set_images(Utils.createBitmapList(new int[]{R.drawable.steve_img_round},
                application.getApplicationContext()));
        question.set_questionType(1);
        question.set_answerType(0);
        question.set_answer("Steve");

        //questionDAO.addQuestion(question);
        int a=1;
    }
    public LiveData<List<Question>> getAllQuestions() {
        return questionDAO.getAllQuestions();
    }
}
