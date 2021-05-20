package jp.co.myself.xacdonald.model.view.menu;

import java.io.Serializable;
import java.util.List;

public class MenuInfoDetailData implements Serializable {

    private List<MenuInfoDetailContent> menuInfoDetailContentList;

    public MenuInfoDetailData(List<MenuInfoDetailContent> menuInfoDetailContentList) {
        this.menuInfoDetailContentList = menuInfoDetailContentList;
    }

    public List<MenuInfoDetailContent> getMenuInfoDetailContentList() {
        return menuInfoDetailContentList;
    }

}
