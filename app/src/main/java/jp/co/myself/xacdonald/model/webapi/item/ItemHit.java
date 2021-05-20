package jp.co.myself.xacdonald.model.webapi.item;

public class ItemHit {

    private ItemImage exImage;

    private String name;

    private Integer price;

    private String description;

    private ItemReview review;

    private ItemPoint point;

    private ItemSeller seller;

    public ItemHit(
            ItemImage exImage,
            String name,
            Integer price,
            String description,
            ItemReview review,
            ItemPoint point,
            ItemSeller seller) {
        this.exImage = exImage;
        this.name = name;
        this.price = price;
        this.description = description;
        this.review = review;
        this.point = point;
        this.seller = seller;
    }

    public ItemImage getExImage() {
        return exImage;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ItemReview getReview() {
        return review;
    }

    public ItemPoint getPoint() {
        return point;
    }

    public ItemSeller getSeller() {
        return seller;
    }

}
