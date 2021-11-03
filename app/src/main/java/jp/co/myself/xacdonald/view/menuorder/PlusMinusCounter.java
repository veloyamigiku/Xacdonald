package jp.co.myself.xacdonald.view.menuorder;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
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

public class PlusMinusCounter extends ConstraintLayout {

    public interface PlusMinusCounterDelegate {
        void tapPlusBtn(int count);
        void tapMinusBtn(int count);
    }

    private Integer count = null;

    private TextView countTv = null;

    private Button minusBtn = null;

    private Button plusBtn = null;

    private PlusMinusCounterDelegate delegate;

    private void plusMinus(int num) {

        count = count + num;
        if (count <= 1) {
            count = 1;
            minusBtn.setBackgroundResource(R.drawable.ic_minus_deactive);
        } else {
            minusBtn.setBackgroundResource(R.drawable.ic_minus_active);
        }

        SpannableStringBuilder countSsb = new SpannableStringBuilder();
        countSsb.append(String.valueOf(count));
        countSsb.setSpan(
                new AbsoluteSizeSpan(20, true),
                0,
                countSsb.length(),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        countSsb.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                countSsb.length(),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        countTv.setText(countSsb);
    }

    public PlusMinusCounter(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        count = 1;

        countTv = new TextView(context);
        countTv.setId(View.generateViewId());
        addView(countTv);

        minusBtn = new Button(context);
        minusBtn.setId(View.generateViewId());
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusMinus(-1);
                if (delegate != null) {
                    delegate.tapMinusBtn(count);
                }
            }
        });
        addView(minusBtn);

        plusBtn = new Button(context);
        plusBtn.setId(View.generateViewId());
        plusBtn.setBackgroundResource(R.drawable.ic_plus_active);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusMinus(1);
                if (delegate != null) {
                    delegate.tapPlusBtn(count);
                }
            }
        });
        addView(plusBtn);

        plusMinus(0);

        ConstraintSet minusBtnCs = new ConstraintSet();
        minusBtnCs.constrainWidth(
                minusBtn.getId(),
                DpPx.convertDp2Px(30, context));
        minusBtnCs.constrainHeight(
                minusBtn.getId(),
                DpPx.convertDp2Px(30, context));
        minusBtnCs.connect(
                minusBtn.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(5, context));
        minusBtnCs.connect(
                minusBtn.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(5, context));
        minusBtnCs.connect(
                minusBtn.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, context));
        minusBtnCs.applyTo(this);

        ConstraintSet countTvCs = new ConstraintSet();
        countTvCs.constrainWidth(
                countTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        countTvCs.constrainHeight(
                countTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        countTvCs.connect(
                countTv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(5, context));
        countTvCs.connect(
                countTv.getId(),
                ConstraintSet.LEFT,
                minusBtn.getId(),
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(20, context));
        countTvCs.connect(
                countTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, context));
        countTvCs.applyTo(this);

        ConstraintSet plusBtnCs = new ConstraintSet();
        plusBtnCs.constrainWidth(
                plusBtn.getId(),
                DpPx.convertDp2Px(30, context));
        plusBtnCs.constrainHeight(
                plusBtn.getId(),
                DpPx.convertDp2Px(30, context));
        plusBtnCs.connect(
                plusBtn.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(5, context));
        plusBtnCs.connect(
                plusBtn.getId(),
                ConstraintSet.LEFT,
                countTv.getId(),
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(20, context));
        plusBtnCs.connect(
                plusBtn.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(5, context));
        plusBtnCs.connect(
                plusBtn.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, context));
        plusBtnCs.applyTo(this);
    }

    public void setDelegate(PlusMinusCounterDelegate delegate) {
        this.delegate = delegate;
    }

    public Integer getCount() {
        return count;
    }

}
