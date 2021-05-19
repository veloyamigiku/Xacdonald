package jp.co.myself.xacdonald.view.menu;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class MenuHeaderViewCreator {

    public static final String ID_LABEL = "label";

    public static TableViewCreatorResult create(Context context, int parentWidth) {

        Map<String, Integer> uiIDViewIDMap = new HashMap<>();

        ConstraintLayout cl = new ConstraintLayout(context);
        cl.setLayoutParams(new Constraints.LayoutParams(
                parentWidth,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView label = new TextView(context);
        label.setId(View.generateViewId());
        label.setGravity(Gravity.START);
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
                5);
        labelCs.connect(
                label.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        labelCs.connect(
                label.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                5);
        labelCs.connect(
                label.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                5);
        labelCs.applyTo(cl);

        return new TableViewCreatorResult(cl, uiIDViewIDMap);
    }

}
