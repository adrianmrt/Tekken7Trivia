package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface QuestionDAO {
    @Insert
    public void addQuestion(Question question);
}
