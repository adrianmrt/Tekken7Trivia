package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

    @Database(entities = {Question.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class QuestionDatabase extends RoomDatabase {
    public abstract QuestionDAO questionDAO();
}
