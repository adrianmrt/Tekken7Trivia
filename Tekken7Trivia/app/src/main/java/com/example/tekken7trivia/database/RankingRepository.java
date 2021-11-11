package com.example.tekken7trivia.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tekken7trivia.main.Utils;

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

    public RankingDAO getRankingDAO() {
        return rankingDAO;
    }
}
