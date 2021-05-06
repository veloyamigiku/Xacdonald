package jp.co.myself.xacdonald.model.webapi.item;

import java.util.List;

import jp.co.myself.xacdonald.model.webapi.keyword.RankingData;

public class ItemWithRankingDataResult {

    private List<ItemHit> hits;

    private RankingData rankingData;

    public ItemWithRankingDataResult(
            List<ItemHit> hits,
            RankingData rankingData) {
        this.hits = hits;
        this.rankingData = rankingData;
    }

    public List<ItemHit> getHits() {
        return hits;
    }

    public RankingData getRankingData() {
        return rankingData;
    }

}
