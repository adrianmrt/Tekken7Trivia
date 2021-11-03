package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.room.Insert;

public interface QuestionDAO {
    @Insert
    public void addQuestion(Question question);
}
