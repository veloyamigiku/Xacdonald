package jp.co.myself.xacdonald.view.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.utils.DpPx;

public class TitleSubHeader extends ConstraintLayout {

    public interface TitleHeaderDelegate {
        void tapLeftBtn();
    }

    private static final int LEFT_BUTTON_SIZE = 30;
    private static final int LEFT_BUTTON_LEFT_MARGIN = 10;

    private TitleHeaderDelegate delegate;
    public TextView titleTv;
    public TextView subTitleTv;

    public TitleSubHeader(@NonNull Context context) {
        super(context);

        setId(View.generateViewId());

        Button leftBtn = new Button(context);
        leftBtn.setId(View.generateViewId());
        leftBtn.setBackgroundResource(R.drawable.ic_back);
        leftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delegate != null) {
                    delegate.tapLeftBtn();
                }
            }
        });
        addView(leftBtn);
        ConstraintSet leftBtnCs = new ConstraintSet();
        leftBtnCs.constrainWidth(
                leftBtn.getId(),
                DpPx.convertDp2Px(LEFT_BUTTON_SIZE, context));
        leftBtnCs.constrainHeight(
                leftBtn.getId(),
                DpPx.convertDp2Px(LEFT_BUTTON_SIZE, context));
        leftBtnCs.connect(
                leftBtn.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(5, context));
        leftBtnCs.connect(
                leftBtn.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(LEFT_BUTTON_LEFT_MARGIN, context));
        leftBtnCs.connect(
                leftBtn.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, context));
        leftBtnCs.applyTo(this);

        ConstraintLayout titleContainer = new ConstraintLayout(context);
        titleContainer.setId(View.generateViewId());
        addView(titleContainer);
        ConstraintSet titleContainerCs = new ConstraintSet();
        titleContainerCs.constrainWidth(
                titleContainer.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        titleContainerCs.constrainHeight(
                titleContainer.getId(),
                ConstraintSet.WRAP_CONTENT);
        titleContainerCs.centerVertically(
                titleContainer.getId(),
                ConstraintSet.PARENT_ID);
        titleContainerCs.connect(
                titleContainer.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(10, context));
        titleContainerCs.connect(
                titleContainer.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(LEFT_BUTTON_LEFT_MARGIN + LEFT_BUTTON_SIZE, context));
        titleContainerCs.connect(
                titleContainer.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(LEFT_BUTTON_LEFT_MARGIN + LEFT_BUTTON_SIZE, context));
        titleContainerCs.connect(
                titleContainer.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(10, context));
        titleContainerCs.applyTo(this);

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

    public void setDelegate(TitleHeaderDelegate delegate) {
        this.delegate = delegate;
    }

}
