package jp.co.myself.xacdonald.view.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;

import jp.co.myself.xacdonald.utils.DpPx;

public class TitleSubHeader extends BaseTitleHeader {

    public TextView titleTv;
    public TextView subTitleTv;

    public TitleSubHeader(@NonNull Context context) {
        super(context);

        titleTv = new TextView(context);
        titleTv.setId(View.generateViewId());
        titleTv.setLines(1);
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

        subTitleTv = new TextView(context);
        subTitleTv.setId(View.generateViewId());
        subTitleTv.setLines(1);
        subTitleTv.setEllipsize(TextUtils.TruncateAt.END);
        subTitleTv.setGravity(Gravity.CENTER_HORIZONTAL);
        titleContainer.addView(subTitleTv);
        ConstraintSet subTitleTvCs = new ConstraintSet();
        subTitleTvCs.constrainWidth(
                subTitleTv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        subTitleTvCs.constrainHeight(
                subTitleTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        subTitleTvCs.connect(
                subTitleTv.getId(),
                ConstraintSet.TOP,
                titleTv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(0, context));
        subTitleTvCs.connect(
                subTitleTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(0, context));
        subTitleTvCs.connect(
                subTitleTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(0, context));
        subTitleTvCs.connect(
                subTitleTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, context));
        subTitleTvCs.applyTo(titleContainer);

    }

}
