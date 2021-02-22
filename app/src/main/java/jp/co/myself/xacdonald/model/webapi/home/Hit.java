package jp.co.myself.xacdonald.model.webapi.home;

public class Hit {

    private ExImage exImage;

    private String name;

    private String price;

    public Hit(ExImage exImage) {
        this.exImage = exImage;
    }

    public ExImage getExImage() {
        return exImage;
    }

    public void setExImage(ExImage exImage) {
        this.exImage = exImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
