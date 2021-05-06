package jp.co.myself.xacdonald.model.webapi.keyword;

import java.util.List;

public class KeywordRanking {

    private List<RankingData> ranking_data;

    public KeywordRanking(List<RankingData> rankingData) {
        this.ranking_data = rankingData;
    }

    public List<RankingData> getRankingData() {
        return ranking_data;
    }

}
