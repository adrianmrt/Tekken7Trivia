package com.example.dadm_p1_albertogarcia_adrianramirez;

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
        int debug=1;
    }

    public DatabaseRepositoryQuestion getQuestionRepo(){
        return questionRepo;
    }
}
