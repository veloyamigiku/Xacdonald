package jp.co.myself.xacdonald.model.view.home;

import java.util.List;

public class HighScoreItemSet extends Item {

    private List<HighScoreItem> highScoreItems;

    public HighScoreItemSet(List<HighScoreItem> highScoreItems) {
        this.highScoreItems = highScoreItems;
    }

    public List<HighScoreItem> getHighScoreItems() {
        return highScoreItems;
    }

    public void setHighScoreItems(List<HighScoreItem> highScoreItems) {
        this.highScoreItems = highScoreItems;
    }

}
