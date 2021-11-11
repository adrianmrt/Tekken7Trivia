package com.example.tekken7trivia.database;


import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

public class InsertRankingAsyncTask extends AsyncTask<RankingUnit, Void, Boolean> {
    private RankingDAO rankingDAO;
    boolean added;
    public InsertRankingAsyncTask(RankingDAO rankingDAO) {this.rankingDAO=rankingDAO;
    }

    @Override
    protected Boolean doInBackground(RankingUnit... rankingUnits) {
        added=false;
        try {
            rankingDAO.addRanking(rankingUnits[0]);
        }catch (SQLiteConstraintException e){
            added=false;
        }
        return added;
    }
}
