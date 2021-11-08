package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.media.Image;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "users")
public class User {
    //@ColumnInfo (name = "user_profile_picture")
    //private Image profilePicture;
    @PrimaryKey
    @NonNull
    @ColumnInfo (name = "user_name")
    private String name;
    @ColumnInfo (name = "user_max_score")
    private int maxScore;
    @ColumnInfo (name = "user_games_played")
    private int numberOfGamesPlayed;
    @ColumnInfo (name = "user_last_time")
    private String lastTimePlayed;

    //public Image getProfilePicture() { return profilePicture; }
    //public void setProfilePicture(Image profilePicture) { this.profilePicture = profilePicture; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }
    public void setNumberOfGamesPlayed(int numberOfGamesPlayed) { this.numberOfGamesPlayed = numberOfGamesPlayed; }

    public String getLastTimePlayed() { return lastTimePlayed; }
    public void setLastTimePlayed(String lastTimePlayed) { this.lastTimePlayed = lastTimePlayed; }
}
