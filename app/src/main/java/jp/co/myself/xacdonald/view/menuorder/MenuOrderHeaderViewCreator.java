package jp.co.myself.xacdonald.view.menuorder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.utils.DpPx;
import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class MenuOrderHeaderViewCreator {

    public static final String ID_LABEL = "label";

    public static TableViewCreatorResult create(Context context) {

        Map<String, Integer> uiIDViewIDMap = new HashMap<>();

        ConstraintLayout cl = new ConstraintLayout(context);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView label = new TextView(context);
        label.setId(View.generateViewId());
        //label.setGravity(Gravity.START);
        uiIDViewIDMap.put(ID_LABEL, label.getId());
        cl.addView(label);
        ConstraintSet labelCs = new ConstraintSet();
        labelCs.constrainHeight(
                label.getId(),
                ConstraintSet.WRAP_CONTENT);
        labelCs.connect(
                label.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(5, context));
        labelCs.connect(
                label.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(5, context));
        labelCs.connect(
                label.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(5, context));
        labelCs.connect(
                label.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, context));
        labelCs.applyTo(cl);

        return new TableViewCreatorResult(cl, uiIDViewIDMap);
    }

}
