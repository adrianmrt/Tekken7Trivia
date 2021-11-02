package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    public abstract  UserDAO userDAO();
}
