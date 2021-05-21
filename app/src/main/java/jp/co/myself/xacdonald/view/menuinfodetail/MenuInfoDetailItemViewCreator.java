package jp.co.myself.xacdonald.view.menuinfodetail;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class MenuInfoDetailItemViewCreator {

    public static final String ID_LABEL = "label";

    public static final String ID_VALUE = "value";

    public static TableViewCreatorResult create(Context context) {

        Map<String, Integer> uiIDViewIDMap = new HashMap<>();

        ConstraintLayout cl = new ConstraintLayout(context);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView label = new TextView(context);
        label.setId(View.generateViewId());
        label.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        uiIDViewIDMap.put(ID_LABEL, label.getId());
        cl.addView(label);
        ConstraintSet labelCs = new ConstraintSet();
        labelCs.constrainWidth(
                label.getId(),
                ConstraintSet.WRAP_CONTENT);
        labelCs.constrainHeight(
                label.getId(),
                ConstraintSet.WRAP_CONTENT);
        labelCs.connect(
                label.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                5);
        labelCs.connect(
                label.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        labelCs.connect(
                label.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                5);
        labelCs.applyTo(cl);

        TextView value = new TextView(context);
        value.setId(View.generateViewId());
        value.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        uiIDViewIDMap.put(ID_VALUE, value.getId());
        cl.addView(value);
        ConstraintSet valueCs = new ConstraintSet();
        valueCs.constrainWidth(
                value.getId(),
                ConstraintSet.WRAP_CONTENT);
        valueCs.constrainHeight(
                value.getId(),
                ConstraintSet.WRAP_CONTENT);
        valueCs.connect(
                value.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                5);
        valueCs.connect(
                value.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                5);
        valueCs.connect(
                value.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                5);
        valueCs.applyTo(cl);

        return new TableViewCreatorResult(cl, uiIDViewIDMap);
    }
}
