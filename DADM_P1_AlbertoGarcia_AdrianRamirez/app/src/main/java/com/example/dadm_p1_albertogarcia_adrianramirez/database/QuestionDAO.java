package com.example.dadm_p1_albertogarcia_adrianramirez.database;

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
}
