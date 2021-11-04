package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dadm_p1_albertogarcia_adrianramirez.main.Utils;

import java.util.List;

public class QuestionRepository {

    private QuestionDAO questionDAO;
    Utils utils;

    public QuestionRepository(Application application) {
        QuestionDatabase questionDatabase = QuestionDatabase.getDatabase(application.getApplicationContext());
        questionDAO = questionDatabase.questionDAO();
    }

    public void InsertQuestion(Question question) {
        new InsertQuestionAsyncTask(questionDAO).execute(question);
    }

    public LiveData<List<Question>> getQuestions() {
        return questionDAO.getAllQuestions();
    }
}
