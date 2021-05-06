package jp.co.myself.xacdonald.model.webapi.item;

public class ItemHit {

    private ItemImage exImage;

    private String name;

    private Integer price;

    private String description;

    public ItemHit(
            ItemImage exImage,
            String name,
            Integer price,
            String description) {
        this.exImage = exImage;
        this.name = name;
        this.price = price;
        this.description = description;
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

}
