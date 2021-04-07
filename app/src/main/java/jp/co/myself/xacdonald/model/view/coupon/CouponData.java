package jp.co.myself.xacdonald.model.view.coupon;

public class CouponData extends CouponBase {

    private String name;

    private String description;

    private int price;

    private String imgUrl;

    public CouponData(String name, String description, int price, String imgUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
