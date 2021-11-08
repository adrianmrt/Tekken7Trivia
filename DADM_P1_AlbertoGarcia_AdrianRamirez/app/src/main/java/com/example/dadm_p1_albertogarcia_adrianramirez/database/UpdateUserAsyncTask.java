package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.os.AsyncTask;

public class UpdateUserAsyncTask extends AsyncTask<Void, Void, Void> {
    private UserDAO _userDAO;
    private String _name;
    private int _score;
    private int _numberOfGamesPlayed;

    public UpdateUserAsyncTask(UserDAO userDAO, String name, int score, int numberOfGamesPlayed) {
        _name=name;
        _score=score;
        _userDAO=userDAO;
        _numberOfGamesPlayed=numberOfGamesPlayed;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        _userDAO.UpdateUser(_name,_score,_numberOfGamesPlayed);
        return null;
    }
}
