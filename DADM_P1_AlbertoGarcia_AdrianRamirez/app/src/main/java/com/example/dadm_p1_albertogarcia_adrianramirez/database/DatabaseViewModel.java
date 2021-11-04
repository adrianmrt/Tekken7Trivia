package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class  DatabaseViewModel extends AndroidViewModel {

    LiveData<List<Question>> allQuestions;
    LiveData<List<User>> allUsers;
    private QuestionRepository questionRepository;
    private UserRepository userRepository;

    public DatabaseViewModel(@NonNull Application application) {
        super(application);
        questionRepository= new QuestionRepository(application);
        userRepository= new UserRepository(application);
        allQuestions= questionRepository.getQuestions();
        allUsers= userRepository.GetUsers();
    }

    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }

    public void InsertQuestion(Question question){ questionRepository.InsertQuestion(question);}
    public void InsertUser(User user){ userRepository.InsertUser(user);}

    public LiveData<List<Question>> getAllQuestions() {
        return allQuestions;
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }
}
