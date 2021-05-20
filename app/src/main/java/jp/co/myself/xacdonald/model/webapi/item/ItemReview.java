package jp.co.myself.xacdonald.model.webapi.item;

public class ItemReview {

    private float rate;

    private int count;

    public ItemReview(float rate, int count) {
        this.rate = rate;
        this.count = count;
    }

    public float getRate() {
        return rate;
    }

    public int getCount() {
        return count;
    }

}
