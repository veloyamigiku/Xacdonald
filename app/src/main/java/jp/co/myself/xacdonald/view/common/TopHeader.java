package jp.co.myself.xacdonald.view.common;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.utils.DpPx;

public class TopHeader extends ConstraintLayout {

    public TopHeader(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        Button leftBtn = new Button(context);
        leftBtn.setId(View.generateViewId());
        leftBtn.setBackgroundColor(Color.TRANSPARENT);
        leftBtn.setCompoundDrawablePadding(-20);
        leftBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.account_default), null, null);
        leftBtn.setText("アカウント");
        leftBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        leftBtn.setTextColor(Color.parseColor("#A9A9A9"));
        leftBtn.setPadding(0, 0, 0, 10);
        addView(leftBtn);
        ConstraintSet leftBtnCs = new ConstraintSet();
        leftBtnCs.constrainWidth(
                leftBtn.getId(),
                DpPx.convertDp2Px(60, getContext()));
        leftBtnCs.constrainHeight(
                leftBtn.getId(),
                DpPx.convertDp2Px(55, getContext()));
        leftBtnCs.connect(
                leftBtn.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                5);
        leftBtnCs.connect(
                leftBtn.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                50);
        leftBtnCs.connect(
                leftBtn.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                5);
        leftBtnCs.applyTo(this);

        Button rightBtn = new Button(context);
        rightBtn.setId(View.generateViewId());
        rightBtn.setBackgroundColor(Color.TRANSPARENT);
        rightBtn.setCompoundDrawablePadding(-20);
        rightBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_point_selector), null, null);
        rightBtn.setText("ポイント");
        rightBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        rightBtn.setTextColor(getResources().getColorStateList(R.color.ic_point_text_selector));
        rightBtn.setPadding(0, 0, 0, 10);
        addView(rightBtn);
        ConstraintSet rightBtnCs = new ConstraintSet();
        rightBtnCs.constrainWidth(
                rightBtn.getId(),
                DpPx.convertDp2Px(55, getContext()));
        rightBtnCs.constrainHeight(
                rightBtn.getId(),
                DpPx.convertDp2Px(55, getContext()));
        rightBtnCs.connect(
                rightBtn.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                5);
        rightBtnCs.connect(
                rightBtn.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                50);
        rightBtnCs.connect(
                rightBtn.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                5);
        rightBtnCs.applyTo(this);

        ImageView centerIv = new ImageView(context);
        centerIv.setId(View.generateViewId());
        centerIv.setBackgroundResource(R.drawable.ic_top);
        addView(centerIv);
        ConstraintSet centerIvCs = new ConstraintSet();
        centerIvCs.constrainWidth(
                centerIv.getId(),
                150);
        centerIvCs.constrainHeight(
                centerIv.getId(),
                150);
        centerIvCs.centerHorizontally(
                centerIv.getId(),
                leftBtn.getId(),
                ConstraintSet.RIGHT,
                0,
                rightBtn.getId(),
                ConstraintSet.LEFT,
                0,
                0.5f);
        centerIvCs.connect(
                centerIv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                10);
        centerIvCs.connect(
                centerIv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                10);
        centerIvCs.applyTo(this);
    }

}
