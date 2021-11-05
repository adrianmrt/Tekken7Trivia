package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ranking")
public class RankingUnit {

    @NonNull
    @ColumnInfo(name = "player_name")
    private String name;
    @NonNull
    @ColumnInfo(name = "score")
    private int score;
    @NonNull
    @ColumnInfo(name = "time")
    private float time;

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
