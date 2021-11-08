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

    @Query("UPDATE users SET user_max_score=:score AND user_games_played=:numberOfGamesPlayed WHERE user_name=:name")
    public void UpdateUser(String name, int score, int numberOfGamesPlayed);


}
