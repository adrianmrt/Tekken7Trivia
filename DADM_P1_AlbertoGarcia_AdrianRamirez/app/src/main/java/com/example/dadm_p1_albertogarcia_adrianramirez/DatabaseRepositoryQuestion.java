package com.example.dadm_p1_albertogarcia_adrianramirez;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DatabaseRepositoryQuestion {

    private DatabaseDaoQuestion qDao;
    private LiveData<List<DatabaseEntityQuestion>> allQuestions;

    DatabaseRepositoryQuestion(Application application) {
        DatabaseApp db = DatabaseApp.getDatabase(application);
        qDao = db.questionDao();
        allQuestions = qDao.getAll();
    }

    LiveData<List<DatabaseEntityQuestion>> getAllQuestions() {
        return allQuestions;
    }

    void addQuestion(DatabaseEntityQuestion question){
        qDao.Insert(question);
    }

}
