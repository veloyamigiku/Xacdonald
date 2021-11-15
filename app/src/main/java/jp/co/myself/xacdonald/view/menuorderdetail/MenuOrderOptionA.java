package jp.co.myself.xacdonald.view.menuorderdetail;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.TransitionManager;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.JustifyContent;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.utils.DpPx;

public class MenuOrderOptionA extends ConstraintLayout {

    public interface MenuOrderOptionADelegate {
        void tapCustomizeBtn();
    }

    private MenuOrderOptionADelegate delegate;

    private ConstraintLayout bodyCl;

    private ConstraintSet bodyClCs;

    private Boolean bodyOpen;

    public MenuOrderOptionA(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TextView optionName = new TextView(context);
        optionName.setId(View.generateViewId());
        addView(optionName);
        ConstraintSet optionNameCs = new ConstraintSet();
        optionNameCs.constrainWidth(
                optionName.getId(),
                ConstraintSet.WRAP_CONTENT);
        optionNameCs.constrainHeight(
                optionName.getId(),
                ConstraintSet.WRAP_CONTENT);
        optionNameCs.connect(
                optionName.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(5, context));
        optionNameCs.connect(
                optionName.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(5, context));
        optionNameCs.applyTo(this);

        Button optionBtn = new Button(context);
        optionBtn.setId(View.generateViewId());
        optionBtn.setText("カスタマイズ");
        optionBtn.setPadding(
                DpPx.convertDp2Px(20, context),
                0,
                DpPx.convertDp2Px(20, context),
                0
        );
        optionBtn.setBackgroundResource(R.drawable.rounded_corners_white_button);
        optionBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {

                    if (bodyOpen) {
                        bodyClCs.constrainHeight(
                                bodyCl.getId(),
                                0);
                        bodyOpen = false;
                    } else {
                        bodyClCs.constrainHeight(
                                bodyCl.getId(),
                                ConstraintSet.WRAP_CONTENT);
                        bodyOpen = true;
                    }
                    TransitionManager.beginDelayedTransition(MenuOrderOptionA.this);
                    bodyClCs.applyTo(MenuOrderOptionA.this);


                    delegate.tapCustomizeBtn();
                }
            }
        });
        addView(optionBtn);
        ConstraintSet optionBtnCs = new ConstraintSet();
        optionBtnCs.constrainWidth(
                optionBtn.getId(),
                ConstraintSet.WRAP_CONTENT);
        optionBtnCs.constrainHeight(
                optionBtn.getId(),
                ConstraintSet.WRAP_CONTENT);
        optionBtnCs.connect(
                optionBtn.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(5, context));
        optionBtnCs.connect(
                optionBtn.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(5, context));
        optionBtnCs.applyTo(this);

        bodyOpen = true;
        bodyCl = new ConstraintLayout(context);
        bodyCl.setId(View.generateViewId());
        addView(bodyCl);
        bodyClCs = new ConstraintSet();
        bodyClCs.constrainWidth(
                bodyCl.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        bodyClCs.constrainHeight(
                bodyCl.getId(),
                ConstraintSet.WRAP_CONTENT);
        bodyClCs.connect(
                bodyCl.getId(),
                ConstraintSet.TOP,
                optionBtn.getId(),
                ConstraintSet.BOTTOM,
                0);
        bodyClCs.connect(
                bodyCl.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        bodyClCs.connect(
                bodyCl.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        bodyClCs.connect(
                bodyCl.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                0);
        bodyClCs.applyTo(this);


        GradientDrawable shape = new GradientDrawable();
        shape.setSize(
                DpPx.convertDp2Px(10, context),
                DpPx.convertDp2Px(10, context));
        shape.setColor(Color.GREEN);


        FlexboxLayout fbl = new FlexboxLayout(context);
        fbl.setId(View.generateViewId());
        fbl.setFlexDirection(FlexDirection.ROW);
        fbl.setFlexWrap(FlexWrap.WRAP);
        fbl.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        fbl.setBackgroundColor(Color.GREEN);
        fbl.setDividerDrawable(shape);
        fbl.setShowDivider(
                FlexboxLayout.SHOW_DIVIDER_BEGINNING |
                        FlexboxLayout.SHOW_DIVIDER_MIDDLE |
                        FlexboxLayout.SHOW_DIVIDER_END);
        bodyCl.addView(fbl);
        ConstraintSet fblCs = new ConstraintSet();
        fblCs.constrainWidth(
                fbl.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        fblCs.constrainHeight(
                fbl.getId(),
                ConstraintSet.WRAP_CONTENT);
        fblCs.connect(
                fbl.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP);
        fblCs.connect(
                fbl.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT);
        fblCs.connect(
                fbl.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT);
        fblCs.connect(
                fbl.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM);
        fblCs.applyTo(bodyCl);


        addBodyTextItem(fbl, context);
        addBodyTextItem(fbl, context);
        addBodyTextItem(fbl, context);
        addBodyTextItem(fbl, context);
        addBodyTextItem(fbl, context);

    }

    private void addBodyTextItem(FlexboxLayout fbl, Context context) {
        TextView bodyTextItem = new TextView(context);
        bodyTextItem.setId(View.generateViewId());
        bodyTextItem.setText("hogehoge");
        bodyTextItem.setBackgroundColor(Color.CYAN);
        FlexboxLayout.LayoutParams bodyTextItemLp = new FlexboxLayout.LayoutParams(
                FlexboxLayout.LayoutParams.WRAP_CONTENT,
                FlexboxLayout.LayoutParams.WRAP_CONTENT);
        bodyTextItemLp.setFlexBasisPercent(0.45f);
        bodyTextItem.setLayoutParams(bodyTextItemLp);
        fbl.addView(bodyTextItem);
    }

    public void setDelegate(MenuOrderOptionADelegate delegate) {
        this.delegate = delegate;
    }

}
