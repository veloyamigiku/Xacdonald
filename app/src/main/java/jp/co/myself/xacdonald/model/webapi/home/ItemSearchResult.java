package jp.co.myself.xacdonald.model.webapi.home;

import java.util.List;

public class ItemSearchResult {

    private List<Hit> hits;

    public ItemSearchResult(List<Hit> hits) {
        this.hits = hits;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
