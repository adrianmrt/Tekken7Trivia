package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.os.AsyncTask;

public class InsertUserAsyncTask extends AsyncTask<User, Void, Void>{
    private UserDAO userDAO;

    public InsertUserAsyncTask(UserDAO userDAO) {this.userDAO=userDAO;
    }

    @Override
    protected Void doInBackground(User... users) {
        userDAO.addUser(users[0]);
        return null;
    }
}
