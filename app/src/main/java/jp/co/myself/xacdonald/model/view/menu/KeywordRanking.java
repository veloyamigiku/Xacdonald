package jp.co.myself.xacdonald.model.view.menu;

public class KeywordRanking {

    private String keyword;

    private Integer ranking;

    public KeywordRanking(
            String keyword,
            Integer ranking) {
        this.keyword = keyword;
        this.ranking = ranking;
    }

    public String getKeyword() {
        return keyword;
    }

    public Integer getRanking() {
        return ranking;
    }

}
