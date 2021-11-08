package jp.co.myself.xacdonald.view.menuorderdetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.utils.DpPx;

public class MenuOrderOptionA extends ConstraintLayout {

    public interface MenuOrderOptionADelegate {
        void tapCustomizeBtn();
    }

    private MenuOrderOptionADelegate delegate;

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
        optionNameCs.connect(
                optionName.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
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
        optionBtnCs.connect(
                optionBtn.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, context));
        optionBtnCs.applyTo(this);

    }

    public void setDelegate(MenuOrderOptionADelegate delegate) {
        this.delegate = delegate;
    }

}
