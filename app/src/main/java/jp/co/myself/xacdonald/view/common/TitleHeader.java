package jp.co.myself.xacdonald.view.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;

import jp.co.myself.xacdonald.utils.DpPx;

public class TitleHeader extends BaseTitleHeader {

    public TextView titleTv;

    public TitleHeader(@NonNull Context context) {
        super(context);

        titleTv = new TextView(context);
        titleTv.setId(View.generateViewId());
        titleTv.setMinLines(1);
        titleTv.setMaxLines(2);
        titleTv.setEllipsize(TextUtils.TruncateAt.END);
        titleTv.setGravity(Gravity.CENTER_HORIZONTAL);
        titleContainer.addView(titleTv);
        ConstraintSet titleTvCs = new ConstraintSet();
        titleTvCs.constrainWidth(
                titleTv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        titleTvCs.constrainHeight(
                titleTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        titleTvCs.connect(
                titleTv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(0, context));
        titleTvCs.connect(
                titleTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(0, context));
        titleTvCs.connect(
                titleTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(0, context));
        titleTvCs.applyTo(titleContainer);

    }

}
