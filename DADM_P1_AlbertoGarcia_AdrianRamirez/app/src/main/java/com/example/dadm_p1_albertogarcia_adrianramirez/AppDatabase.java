package com.example.dadm_p1_albertogarcia_adrianramirez;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {QuestionStructure.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();
}
