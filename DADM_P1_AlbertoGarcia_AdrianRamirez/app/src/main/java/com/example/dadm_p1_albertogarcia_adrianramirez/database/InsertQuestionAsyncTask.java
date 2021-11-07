package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import com.example.dadm_p1_albertogarcia_adrianramirez.database.Question;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.QuestionDAO;

public class InsertQuestionAsyncTask extends AsyncTask<Question, Void, Boolean> {
    private QuestionDAO questionDAO;
    boolean added;
    public InsertQuestionAsyncTask(QuestionDAO questionDAO) {this.questionDAO=questionDAO;
    }

    @Override
    protected Boolean doInBackground(Question... questions) {
        added=false;
        try {
            questionDAO.addQuestion(questions[0]);
        }catch (SQLiteConstraintException e){
            added=false;
        }
        return added;
    }
}
