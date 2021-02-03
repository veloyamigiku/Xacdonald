package jp.co.myself.xacdonald.model.view.home;

public class LowPriceItem extends Item {

    private String imageUrl;

    public LowPriceItem(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
