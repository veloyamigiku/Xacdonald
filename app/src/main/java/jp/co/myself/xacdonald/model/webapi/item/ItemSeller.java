package jp.co.myself.xacdonald.model.webapi.item;

public class ItemSeller {

    private String name;

    private ItemSellerReview review;

    public ItemSeller(
            String name,
            ItemSellerReview review) {
        this.name = name;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public ItemSellerReview getReview() {
        return review;
    }

}
