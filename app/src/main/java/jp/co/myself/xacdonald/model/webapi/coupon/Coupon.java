package jp.co.myself.xacdonald.model.webapi.coupon;

import jp.co.myself.xacdonald.model.webapi.home.ExImage;

public class Coupon {

    private ExImage exImage;

    private String name;

    private String price;

    private String description;

    public Coupon(
            ExImage exImage,
            String name,
            String price) {
        this.exImage = exImage;
        this.name = name;
        this.price = price;
    }

    public ExImage getExImage() {
        return exImage;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
