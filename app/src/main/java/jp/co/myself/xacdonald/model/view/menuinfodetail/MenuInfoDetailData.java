package jp.co.myself.xacdonald.model.view.menuinfodetail;

import java.io.Serializable;
import java.util.List;

public class MenuInfoDetailData implements Serializable {

    private List<MenuInfoDetailBase> menuInfoDetailBaseList;

    public MenuInfoDetailData(List<MenuInfoDetailBase> menuInfoDetailBaseList) {
        this.menuInfoDetailBaseList = menuInfoDetailBaseList;
    }

    public List<MenuInfoDetailBase> getMenuInfoDetailBaseList() {
        return menuInfoDetailBaseList;
    }

}
