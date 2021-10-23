package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {QuestionStructure.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract QuestionDao questionDao();
}
