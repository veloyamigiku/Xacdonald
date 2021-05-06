package jp.co.myself.xacdonald.model.webapi.keyword;

public class KeywordRankingResult {

    private KeywordRanking keyword_ranking;

    public KeywordRankingResult(KeywordRanking keywordRanking) {
        this.keyword_ranking = keywordRanking;
    }

    public KeywordRanking getKeywordRanking() {
        return keyword_ranking;
    }

}
