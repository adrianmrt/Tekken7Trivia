package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DatabaseDaoQuestion {

    @Insert
    void Insert(DatabaseEntityQuestion question);

    @Query("DELETE FROM Questions")
    void deleteAll();

    @Query("SELECT * from Questions ORDER BY questionId ASC")
    LiveData<List<DatabaseEntityQuestion>> getAll();

}

