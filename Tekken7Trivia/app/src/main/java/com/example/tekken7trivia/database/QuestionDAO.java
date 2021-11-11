package com.example.tekken7trivia.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDAO {
    @Insert
    public void addQuestion(Question question);

    @Query("DELETE FROM Questions")
    void deleteAll();

    @Query("SELECT * from Questions ORDER BY questionId ASC")
    LiveData<List<Question>> getAllQuestions();

    @Query("SELECT * from Questions WHERE questionId=:id")
    Question getQuestion(int id);

    @Query("SELECT _question from Questions WHERE questionId=:id")
    String getQuestionText(int id);

    @Query("SELECT _questionType from Questions WHERE questionId=:id")
    int getQuestionType(int id);

    @Query("SELECT _answerType from Questions WHERE questionId=:id")
    int getAnswerType(int id);

    @Query("SELECT _answer from Questions WHERE questionId=:id")
    String getAnswer(int id);

    @Query("SELECT _questionBlock from Questions WHERE questionId=:id")
    String getQuestionBlock(int id);

    @Query("SELECT _multimediaFileId from Questions WHERE questionId=:id")
    int getMultimedia(int id);
}
