package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import com.example.dadm_p1_albertogarcia_adrianramirez.main.Utils;

public class UserRepository {

    UserDAO userDAO;
    Utils utils;

    public UserRepository(Application application) {
        UserDataBase userDataBase= UserDataBase.getUserDatabase(application.getApplicationContext());
        userDAO= userDataBase.userDAO();
    }

    public void InsertUser(User user){new InsertUserAsyncTask(userDAO).execute(user);}
}
