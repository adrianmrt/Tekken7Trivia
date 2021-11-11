package com.example.tekken7trivia.database;

import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

public class InsertUserAsyncTask extends AsyncTask<User, Void, Boolean>{
    private UserDAO userDAO;
    boolean added;

    public InsertUserAsyncTask(UserDAO userDAO) {this.userDAO=userDAO;
    }

    @Override
    protected Boolean doInBackground(User... users) {
        added = false;
        try {
            userDAO.addUser(users[0]);
            ;
        } catch (SQLiteConstraintException e) {
            added = false;
        }

        publishProgress();
        return added;
    }
}
