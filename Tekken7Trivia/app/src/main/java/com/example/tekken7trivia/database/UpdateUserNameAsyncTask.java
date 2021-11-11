package com.example.tekken7trivia.database;

import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

public class UpdateUserNameAsyncTask  extends AsyncTask<Void, Void, Boolean> {
    private UserDAO userDAO;
    boolean added;
    String id;
    String name;

    public UpdateUserNameAsyncTask(UserDAO userDAO,String id, String name) {
        this.userDAO=userDAO;
        this.id=id;
        this.name=name;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        added = false;
        try {
            userDAO.UpdateUserName(id,name);
            added=true;
        } catch (SQLiteConstraintException e) {
            added = false;
        }
        return added;
    }
}
