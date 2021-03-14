package jp.co.myself.xacdonald.view.home;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HighScoreItemSetViewHolder extends RecyclerView.ViewHolder {

    List<HighScoreItemView> highScoreItemViewList;

    public HighScoreItemSetViewHolder(@NonNull View itemView, Map<String, Integer> uiIDResIDMap) {
        super(itemView);

        highScoreItemViewList = new ArrayList<>();
        List<String> uiIDList = new ArrayList<>();
        for (String uiID : uiIDResIDMap.keySet()) {
            if (uiID.startsWith(HighScoreItemSetViewCreator.ID_HIGH_SCORE_ITEM_VIEW_PREFIX)) {
                uiIDList.add(uiID);
            }
        }
        Collections.sort(uiIDList);
        for (String uiID : uiIDList) {
            highScoreItemViewList.add(itemView.findViewById(uiIDResIDMap.get(uiID)));
        }

    }

}
