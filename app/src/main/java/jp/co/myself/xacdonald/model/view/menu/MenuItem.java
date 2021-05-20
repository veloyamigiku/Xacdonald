package jp.co.myself.xacdonald.model.view.menu;

public class MenuItem extends MenuBase {

    private String name;

    private String imgUrl;

    private int price;

    private String description;

    private float reviewRate;

    private int reviewCount;

    private int pointAmount;

    private int pointTimes;

    private int pointBonusAmount;

    private int pointBonusTimes;

    private int pointPremiumAmount;

    private int pointPremiumTimes;

    private int pointPremiumBonusAmount;

    private int pointPremiumBonusTime;

    private String sellerName;

    private float sellerReviewRate;

    private int sellerReviewCount;

    public MenuItem(
            String name,
            String imgUrl,
            int price,
            String description,
            float reviewRate,
            int reviewCount,
            int pointAmount,
            int pointTimes,
            int pointBonusAmount,
            int pointBonusTimes,
            int pointPremiumAmount,
            int pointPremiumTimes,
            int pointPremiumBonusAmount,
            int pointPremiumBonusTimes,
            String sellerName,
            float sellerReviewRate,
            int sellerReviewCount) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
        this.reviewRate = reviewRate;
        this.reviewCount = reviewCount;
        this.pointAmount = pointAmount;
        this.pointTimes = pointTimes;
        this.pointBonusAmount = pointBonusAmount;
        this.pointBonusTimes = pointBonusTimes;
        this.pointPremiumAmount = pointPremiumAmount;
        this.pointPremiumTimes = pointPremiumTimes;
        this.pointPremiumBonusAmount = pointPremiumBonusAmount;
        this.pointPremiumBonusTime = pointPremiumBonusTimes;
        this.sellerName = sellerName;
        this.sellerReviewRate = sellerReviewRate;
        this.sellerReviewCount = sellerReviewCount;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public float getReviewRate() {
        return reviewRate;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public int getPointAmount() {
        return pointAmount;
    }

    public int getPointTimes() {
        return pointTimes;
    }

    public int getPointBonusAmount() {
        return pointBonusAmount;
    }

    public int getPointBonusTimes() {
        return pointBonusTimes;
    }

    public int getPointPremiumAmount() {
        return pointPremiumAmount;
    }

    public int getPointPremiumTimes() {
        return pointPremiumTimes;
    }

    public int getPointPremiumBonusAmount() {
        return pointPremiumBonusAmount;
    }

    public int getPointPremiumBonusTime() {
        return pointPremiumBonusTime;
    }

    public String getSellerName() {
        return sellerName;
    }

    public float getSellerReviewRate() {
        return sellerReviewRate;
    }

    public int getSellerReviewCount() {
        return sellerReviewCount;
    }

}
