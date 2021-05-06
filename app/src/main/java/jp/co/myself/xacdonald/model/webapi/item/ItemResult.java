package jp.co.myself.xacdonald.model.webapi.item;

import java.util.List;

public class ItemResult {

    private List<ItemHit> hits;

    private ItemRequest request;

    public ItemResult(
            List<ItemHit> hits,
            ItemRequest request) {
        this.hits = hits;
        this.request = request;
    }

    public List<ItemHit> getHits() {
        return hits;
    }

    public ItemRequest getRequest() {
        return request;
    }

}
