package jp.co.myself.xacdonald.model.view.menuorder;

import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Objects;

import jp.co.myself.xacdonald.model.view.menu.MenuItem;

public class MenuOrderItem {

    private MenuItem item;

    private int order;

    public MenuOrderItem(MenuItem item) {
        this.item = item;
        order = -1;
    }

    public MenuItem getItem() {
        return item;
    }

    @Override
    public boolean equals(@Nullable Object obj) {

        boolean result = false;

        if (obj instanceof MenuOrderItem) {
            MenuOrderItem targetMenuOrderItem = (MenuOrderItem) obj;
            MenuItem targetMenuItem = targetMenuOrderItem.getItem();
            if (item.equals(targetMenuItem)) {
                result = true;
            }
        }

        return result;

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        int code = Objects.hash(item);
        return code;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MenuOrderItem[");
        sb.append("order:" + order + "\n");
        sb.append("item:" + item.toString() + "\n");
        sb.append("]\n");
        return sb.toString();
    }
}
