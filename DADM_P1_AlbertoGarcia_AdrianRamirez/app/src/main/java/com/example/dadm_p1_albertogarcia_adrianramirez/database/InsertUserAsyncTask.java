package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.dadm_p1_albertogarcia_adrianramirez.database.User;
import com.example.dadm_p1_albertogarcia_adrianramirez.database.UserDAO;

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
