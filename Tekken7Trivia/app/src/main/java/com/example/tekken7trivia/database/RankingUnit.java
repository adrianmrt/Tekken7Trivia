package com.example.tekken7trivia.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ranking")
public class RankingUnit {

    @PrimaryKey
    @NonNull
    private int innerId;

    @ColumnInfo(name = "player_name")
    private String name;

    @ColumnInfo(name = "score")
    private int score;

    @ColumnInfo(name = "time")
    private float time;

    public float getTime() {
        return time;
    }

    public int getScore() {
        return score;
    }

    public int getInnerId() {
        return innerId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public void setInnerId(int innerId) {
        this.innerId = innerId;
    }
}
