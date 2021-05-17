package jp.co.myself.xacdonald.model.view.menu;

public class MenuItem extends MenuBase {

    private String name;

    private String imgUrl;

    private int price;

    private String description;

    public MenuItem(
            String name,
            String imgUrl,
            int price,
            String description) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
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

}
