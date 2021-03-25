package jp.co.myself.xacdonald.model.webapi.coupon;

import java.util.List;

public class CouponSearchResult {

    private List<Coupon> hits;

    public CouponSearchResult(List<Coupon> hits) {
        this.hits = hits;
    }

    public List<Coupon> getHits() {
        return hits;
    }

}
