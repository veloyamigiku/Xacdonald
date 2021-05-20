package jp.co.myself.xacdonald.model.view.menu;

import java.io.Serializable;

public class MenuInfoDetailItem implements Serializable {

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
