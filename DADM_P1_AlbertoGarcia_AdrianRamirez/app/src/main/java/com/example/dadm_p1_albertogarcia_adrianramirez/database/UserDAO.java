package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    public void addUser(User user);

    @Query("SELECT * FROM users ORDER BY user_name ASC")
    public LiveData<List<User>> getUsers();

    @Query("DELETE FROM users WHERE user_name=:name")
    public void Delete(String name);

    @Query("SELECT * FROM users WHERE user_name=:name")
    public User GetUser(String name);

    @Query("UPDATE users SET user_max_score=:score, user_games_played=:numberOfGamesPlayed, user_last_time=:lastDate WHERE user_name=:name")
    public void UpdateUser(String name, float score, int numberOfGamesPlayed, String lastDate);

    @Query("UPDATE users SET user_name=:name WHERE user_name=:id")
    public void UpdateUserName(String id, String name);

}
