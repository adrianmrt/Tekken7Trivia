package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DatabaseViewModel extends AndroidViewModel {

    LiveData<List<Question>> allQuestions;
    private QuestionRepository questionRepository;

    public DatabaseViewModel(@NonNull Application application) {
        super(application);
        questionRepository= new QuestionRepository(application);
        //allQuestions= questionRepository.getAllQuestions();
    }

    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }
}
