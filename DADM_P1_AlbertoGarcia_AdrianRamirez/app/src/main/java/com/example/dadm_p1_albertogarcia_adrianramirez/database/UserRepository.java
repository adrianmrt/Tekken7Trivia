package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dadm_p1_albertogarcia_adrianramirez.Utils;

import java.util.List;

public class UserRepository {

    UserDAO userDAO;
    Utils utils;

    public UserRepository(Application application) {
        UserDataBase userDataBase= UserDataBase.getUserDatabase(application.getApplicationContext());
        userDAO= userDataBase.userDAO();
    }
    public void InsertUser(User user){new InsertUserAsyncTask(userDAO).execute(user);}
    public LiveData<List<User>>GetUsers(){return userDAO.getUsers();};

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
