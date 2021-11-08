package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dadm_p1_albertogarcia_adrianramirez.main.Utils;

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
    public void DeleteUser(String name){userDAO.Delete(name);}
    public User GetUser(String name){return userDAO.GetUser(name);}
    public UserDAO getUserDAO() {
        return userDAO;
    }
    public void UpdateUser(String name, int score, int numberOfGamesPlayed){new UpdateUserAsyncTask(userDAO, name, score,numberOfGamesPlayed);}
}
