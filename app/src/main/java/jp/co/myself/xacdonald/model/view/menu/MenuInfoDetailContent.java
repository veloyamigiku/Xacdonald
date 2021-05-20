package jp.co.myself.xacdonald.model.view.menu;

import java.io.Serializable;
import java.util.List;

public class MenuInfoDetailContent implements Serializable {

    private String contentLabel;

    private List<MenuInfoDetailItem> menuInfoDetailItemList;

    public MenuInfoDetailContent(
            String contentLabel,
            List<MenuInfoDetailItem> menuInfoDetailItemList) {
        this.contentLabel = contentLabel;
        this.menuInfoDetailItemList = menuInfoDetailItemList;
    }

    public String getContentLabel() {
        return contentLabel;
    }

    public List<MenuInfoDetailItem> getMenuInfoDetailItemList() {
        return menuInfoDetailItemList;
    }

}
