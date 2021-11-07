package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.os.AsyncTask;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

public class ReadDBAsyncTask extends AsyncTask<Integer,Void,Question> {
    private QuestionDAO questionDAO;
    int _elementId;

    public ReadDBAsyncTask(int elementId) {
        _elementId=elementId;
    }

    @Override
    protected Question doInBackground(Integer... integers) {
        return questionDAO.getQuestion(integers[0]);
    }
}

