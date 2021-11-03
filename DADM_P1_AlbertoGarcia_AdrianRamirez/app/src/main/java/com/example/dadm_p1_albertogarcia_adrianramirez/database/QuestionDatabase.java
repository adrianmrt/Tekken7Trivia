package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class QuestionDatabase extends RoomDatabase {
    public abstract QuestionDAO questionDAO();
}
