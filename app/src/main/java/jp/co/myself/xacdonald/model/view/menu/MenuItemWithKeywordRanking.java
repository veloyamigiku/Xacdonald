package jp.co.myself.xacdonald.model.view.menu;

import java.util.List;

public class MenuItemWithKeywordRanking {

    private List<MenuItem> menuItemList;

    private KeywordRanking keywordRanking;

    public MenuItemWithKeywordRanking(
            List<MenuItem> menuItemList,
            KeywordRanking keywordRanking) {
        this.menuItemList = menuItemList;
        this.keywordRanking = keywordRanking;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public KeywordRanking getKeywordRanking() {
        return keywordRanking;
    }

}
