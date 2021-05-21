package jp.co.myself.xacdonald.model.view.menuinfodetail;

import java.io.Serializable;

public class MenuInfoDetailHeader extends MenuInfoDetailBase implements Serializable {

    private String label;

    public MenuInfoDetailHeader(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
