package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {

    @Insert
    void Insert(QuestionStructure2 question);

    @Query("SELECT * FROM Questions")
    List<QuestionStructure2> getAll();

}

