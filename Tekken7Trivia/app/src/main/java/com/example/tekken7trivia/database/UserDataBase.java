package com.example.tekken7trivia.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDataBase extends RoomDatabase {
    public abstract  UserDAO userDAO();

    private static UserDataBase INSTANCE;

    public static UserDataBase getUserDatabase(Context applicationContext) {
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(applicationContext,UserDataBase.class, "userdb").build();
        }
        return INSTANCE;
    }


}
