package jp.co.myself.xacdonald.view.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.utils.DpPx;

abstract public class BaseTitleHeader extends ConstraintLayout {

    public interface TitleHeaderDelegate {
        void tapLeftBtn();
    }

    private static final int LEFT_BUTTON_SIZE = 30;
    private static final int LEFT_BUTTON_LEFT_MARGIN = 10;

    private TitleSubHeader.TitleHeaderDelegate delegate;
    protected ConstraintLayout titleContainer;

    public BaseTitleHeader(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

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

        titleContainer = new ConstraintLayout(context);
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
    }

    /*public BaseTitleHeader(@NonNull Context context) {
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

        titleContainer = new ConstraintLayout(context);
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
    }*/

    public void setDelegate(TitleSubHeader.TitleHeaderDelegate delegate) {
        this.delegate = delegate;
    }

}
