package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

    @Database(entities = {Question.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class QuestionDatabase extends RoomDatabase {
    public abstract QuestionDAO questionDAO();
    private static QuestionDatabase INSTANCE;

    static QuestionDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context,QuestionDatabase.class, "questiondb").build();
        }
        return INSTANCE;
    }
}
