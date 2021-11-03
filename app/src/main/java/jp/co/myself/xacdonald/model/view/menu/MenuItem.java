package jp.co.myself.xacdonald.model.view.menu;

import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Objects;

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

    private int pointPremiumBonusTimes;

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
        this.pointPremiumBonusTimes = pointPremiumBonusTimes;
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

    public int getPointPremiumBonusTimes() {
        return pointPremiumBonusTimes;
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

    @Override
    public boolean equals(@Nullable Object obj) {

        boolean result = false;

        if (obj instanceof MenuItem) {
            MenuItem targetMenuItem = (MenuItem) obj;
            if (name.equals(targetMenuItem.getName()) &&
                    imgUrl.equals(targetMenuItem.getImgUrl()) &&
                    price == targetMenuItem.getPrice()) {
                result = true;
            }
        }

        return result;

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        int code = Objects.hash(name, imgUrl, price);
        return code;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MenuItem[");
        sb.append("name:" + name + "\n");
        sb.append("imgUrl:" + imgUrl + "\n");
        sb.append("price:" + price + "\n");
        sb.append("]");
        return sb.toString();
    }
}
