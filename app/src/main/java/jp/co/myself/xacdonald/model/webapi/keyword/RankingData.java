package jp.co.myself.xacdonald.model.webapi.keyword;

public class RankingData {

    private Integer rank;

    private String query;

    public RankingData(
            Integer rank,
            String query) {
        this.rank = rank;
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public Integer getRank() {
        return rank;
    }

}
