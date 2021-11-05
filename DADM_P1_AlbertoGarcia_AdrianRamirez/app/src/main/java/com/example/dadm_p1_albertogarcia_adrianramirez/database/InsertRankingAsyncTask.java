package com.example.dadm_p1_albertogarcia_adrianramirez.database;


import android.os.AsyncTask;

public class InsertRankingAsyncTask extends AsyncTask<RankingUnit, Void, Void> {
    private RankingDAO rankingDAO;

    public InsertRankingAsyncTask(RankingDAO rankingDAO) {this.rankingDAO=rankingDAO;
    }

    @Override
    protected Void doInBackground(RankingUnit... rankingUnits) {
        rankingDAO.addRanking(rankingUnits[0]);
        return null;
    }
}
