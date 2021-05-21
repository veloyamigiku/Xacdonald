package jp.co.myself.xacdonald.view.menuinfodetail;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class MenuInfoDetailHeaderViewCreator {

    public static final String ID_LABEL = "label";

    public static TableViewCreatorResult create(Context context) {

        Map<String, Integer> uiIDResIDMap = new HashMap<>();

        ConstraintLayout cl = new ConstraintLayout(context);

        TextView label = new TextView(context);
        label.setId(View.generateViewId());
        label.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        uiIDResIDMap.put(ID_LABEL, label.getId());
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
                60);
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

        return new TableViewCreatorResult(cl, uiIDResIDMap);
    }
}
