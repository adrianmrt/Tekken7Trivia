package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    public void addUser(User user);

    @Query("SELECT * FROM users ORDER BY user_name ASC")
    public LiveData<List<User>> getUsers();
}
