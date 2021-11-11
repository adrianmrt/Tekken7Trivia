package com.example.tekken7trivia.database;

import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

public class DeleteUserAsyncTask extends AsyncTask<String, Void, Boolean> {
    private UserDAO userDAO;
    boolean added;

    public DeleteUserAsyncTask(UserDAO userDAO) {this.userDAO=userDAO;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        added = false;
        try {
            userDAO.Delete(strings[0]);
            ;
        } catch (SQLiteConstraintException e) {
            added = false;
        }
        return added;
    }
}
