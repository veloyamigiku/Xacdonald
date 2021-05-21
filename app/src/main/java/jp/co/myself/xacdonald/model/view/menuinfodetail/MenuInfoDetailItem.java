package jp.co.myself.xacdonald.model.view.menuinfodetail;

import java.io.Serializable;

public class MenuInfoDetailItem extends MenuInfoDetailBase implements Serializable {

    private String label;

    private String value;

    public MenuInfoDetailItem(
            String label,
            String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

}
