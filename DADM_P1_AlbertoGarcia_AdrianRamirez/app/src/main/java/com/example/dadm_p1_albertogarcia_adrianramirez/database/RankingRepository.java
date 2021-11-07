package com.example.dadm_p1_albertogarcia_adrianramirez.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dadm_p1_albertogarcia_adrianramirez.main.Utils;

import java.util.List;

public class RankingRepository {
    private RankingDAO rankingDAO;
    Utils utils;

    public RankingRepository(Application application) {
        RankingDatabase rankingDatabase = RankingDatabase.getDatabase(application.getApplicationContext());
        rankingDAO = rankingDatabase.rankingDAO();
    }

    public void InsertRanking(RankingUnit rankingUnit) {
        new InsertRankingAsyncTask(rankingDAO).execute(rankingUnit);
    }

    public LiveData<List<RankingUnit>> getRanking() {
        return rankingDAO.getRanking();
    }
}
