package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DatabaseViewModel extends AndroidViewModel {

    LiveData<List<DatabaseEntityQuestion>> readAllData;
    private DatabaseRepositoryQuestion questionRepo;

    public DatabaseViewModel(@NonNull Application application) {
        super(application);
        questionRepo= new DatabaseRepositoryQuestion(application);
        readAllData= questionRepo.getAllQuestions();
    }

    public DatabaseRepositoryQuestion getQuestionRepo(){
        return questionRepo;
    }
}
