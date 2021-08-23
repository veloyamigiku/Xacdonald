package jp.co.myself.xacdonald.view.shop;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class ShopItemViewCreator {

    public static final String ID_TV = "tv";

    public static TableViewCreatorResult create(
            Context context) {

        Map<String, Integer> uiIDResIDMap = new HashMap<>();

        ConstraintLayout cl = new ConstraintLayout(context);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView tv = new TextView(context);
        tv.setId(View.generateViewId());
        tv.setTextColor(Color.BLACK);
        uiIDResIDMap.put(ID_TV, tv.getId());
        cl.addView(tv);
        ConstraintSet tvCs = new ConstraintSet();
        tvCs.constrainHeight(
                tv.getId(),
                ConstraintSet.WRAP_CONTENT);
        tvCs.connect(
                tv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                10);
        tvCs.connect(
                tv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                10);
        tvCs.connect(
                tv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                10);
        tvCs.connect(
                tv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                10);
        tvCs.applyTo(cl);

        return new TableViewCreatorResult(
                cl,
                uiIDResIDMap);

    }
}
