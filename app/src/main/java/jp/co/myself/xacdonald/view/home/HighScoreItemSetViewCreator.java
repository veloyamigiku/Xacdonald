package jp.co.myself.xacdonald.view.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class HighScoreItemSetViewCreator {

    public static final String ID_HIGH_SCORE_ITEM_VIEW_PREFIX = "HighScoreItemView";

    public static TableViewCreatorResult create(
            Context context,
            int rowCount,
            int colCount,
            int parentWidth) {

        Map<String, Integer> uiIDResIDMap = new HashMap<>();

        LinearLayout mainLl = new LinearLayout(context);
        mainLl.setOrientation(LinearLayout.VERTICAL);
        mainLl.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            LinearLayout subLl = new LinearLayout(context);
            subLl.setOrientation(LinearLayout.HORIZONTAL);
            subLl.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            mainLl.addView(subLl);
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                HighScoreItemView highScoreItemView = new HighScoreItemView(context);
                highScoreItemView.setId(View.generateViewId());
                highScoreItemView.setLayoutParams(new LinearLayout.LayoutParams(
                        parentWidth / 2,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                uiIDResIDMap.put(
                        HighScoreItemSetViewCreator.ID_HIGH_SCORE_ITEM_VIEW_PREFIX + (rowIdx * rowCount + colIdx),
                        highScoreItemView.getId());
                subLl.addView(highScoreItemView);
            }
        }
        return new TableViewCreatorResult(
                mainLl,
                uiIDResIDMap);

    }

}
