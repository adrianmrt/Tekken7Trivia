package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RankingDAO {
    @Insert
    public void addRanking(RankingUnit rankingUnit);

    @Query("DELETE FROM ranking")
    void deleteAll();

    @Query("SELECT * from ranking ORDER BY score DESC, time ASC")
    LiveData<List<RankingUnit>> getRanking();
}
