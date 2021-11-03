package jp.co.myself.xacdonald.model.view.menuorder;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.model.view.menu.MenuItem;

public class MenuOrderManager {

    Map<MenuOrderItem, Integer> menuOrderItemMap = null;

    public MenuOrderManager() {
        this.menuOrderItemMap = new HashMap<>();
    }

    public void update(MenuItem menuItem, int menuItemCount) {

        MenuOrderItem targetMenuOrderItem = new MenuOrderItem(menuItem);

        if (menuOrderItemMap.containsKey(targetMenuOrderItem)) {
            menuOrderItemMap.put(
                    targetMenuOrderItem,
                    menuOrderItemMap.get(targetMenuOrderItem) + menuItemCount);
        } else {
            targetMenuOrderItem.setOrder(menuOrderItemMap.size() + 1);
            menuOrderItemMap.put(
                    targetMenuOrderItem,
                    menuItemCount);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MenuOrderManager:[");
        sb.append("MenuOrderItemMap.size():" + menuOrderItemMap.size() + "\n");
        sb.append("MenuOrderItemMap:\n");
        for (MenuOrderItem menuOrderItem : menuOrderItemMap.keySet()) {
            sb.append(menuOrderItem.toString());
            sb.append("menuItemCount:" + menuOrderItemMap.get(menuOrderItem) + "\n");
        }
        sb.append("]");
        return sb.toString();
    }

}
