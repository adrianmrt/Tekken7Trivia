package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    public void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();
}
