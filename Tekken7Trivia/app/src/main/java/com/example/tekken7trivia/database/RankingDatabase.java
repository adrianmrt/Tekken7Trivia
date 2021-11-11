package com.example.tekken7trivia.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RankingUnit.class}, version = 1)
public abstract class RankingDatabase extends RoomDatabase {
    public abstract RankingDAO rankingDAO();
    private static RankingDatabase INSTANCE;


    static RankingDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context,RankingDatabase.class, "rankingdb").build();
        }
        return INSTANCE;
    }
}
