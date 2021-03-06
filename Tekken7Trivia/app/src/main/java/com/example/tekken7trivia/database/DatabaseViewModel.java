package com.example.tekken7trivia.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class  DatabaseViewModel extends AndroidViewModel {

    LiveData<List<Question>> allQuestions;
    List<Question> allQuestionsD;
    LiveData<List<User>> allUsers;
    LiveData<List<RankingUnit>> ranking;

    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private RankingRepository rankingRepository;

    public DatabaseViewModel(@NonNull Application application) {
        super(application);
        questionRepository= new QuestionRepository(application);
        userRepository= new UserRepository(application);
        rankingRepository= new RankingRepository(application);

        allQuestions= questionRepository.getQuestions();
        allQuestionsD= allQuestions.getValue();
        allUsers= userRepository.GetUsers();
        ranking= rankingRepository.getRanking();

    }

    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }

    public void InsertQuestion(Question question){ questionRepository.InsertQuestion(question);}
    public void InsertUser(User user){ userRepository.InsertUser(user);}
    public void InsertRanking(RankingUnit rankingUnit){ rankingRepository.InsertRanking(rankingUnit);}

    public LiveData<List<Question>> getAllQuestions() {
        return allQuestions;
    }
    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }
    public LiveData<List<RankingUnit>> getAllRanking() {
        return ranking;
    }

    public String getAnswer(int id) {
        return questionRepository.getAnswer(id);
    }

    public UserDAO getUserDao(){
        return userRepository.getUserDAO();
    }

    public QuestionDAO getQuestionDao(){
        return questionRepository.getQuestionDAO();
    }

    public RankingDAO getRankingDao(){
        return rankingRepository.getRankingDAO();
    }

    public Question GetQuestion(int id){ return questionRepository.getQuestion(id);};
    public void DeleteUser(String name){userRepository.DeleteUser(name);}
    public User GetUser(String name){return userRepository.GetUser(name);}

    public void UpdateUser(String name,float score, int numberOfGamesPlayed, String lastDate){userRepository.UpdateUser(name,score,numberOfGamesPlayed,lastDate);}
    public void UpdateUserName(String name, String newName){userRepository.UpdateUserName(name,newName);}
}
