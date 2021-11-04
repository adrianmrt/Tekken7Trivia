package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.os.AsyncTask;

import com.example.dadm_p1_albertogarcia_adrianramirez.database.Question;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.QuestionDAO;

public class InsertQuestionAsyncTask extends AsyncTask<Question, Void, Void> {
    private QuestionDAO questionDAO;

    public InsertQuestionAsyncTask(QuestionDAO questionDAO) {this.questionDAO=questionDAO;
    }

    @Override
    protected Void doInBackground(Question... questions) {
        questionDAO.addQuestion(questions[0]);
        return null;
    }
}
