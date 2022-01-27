package jp.co.myself.xacdonald.view.menuorder;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.TransitionManager;

import jp.co.myself.xacdonald.utils.DpPx;

public class MenuOrderBottomView extends ConstraintLayout implements View.OnTouchListener {

    private final int HEIGHT_DP_MAX = DpPx.convertDp2Px(100, getContext());
    private final int HEIGHT_DP_TAP_MAX = DpPx.convertDp2Px(99, getContext());
    private final int HEIGHT_DP_THRESHOLD = DpPx.convertDp2Px(50, getContext());
    private final int HEIGHT_DP_MIN = DpPx.convertDp2Px(0, getContext());
    private final int HEIGHT_DP_TAP_MIN = DpPx.convertDp2Px(1, getContext());

    private ConstraintSet cl1Cs;
    private ConstraintLayout cl1;
    private int vHeightDp = DpPx.convertDp2Px(0, getContext());
    private boolean vOpenFlg = false;
    private int pressedY;

    public MenuOrderBottomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(Color.GRAY);
        setOnTouchListener(this);

        cl1 = new ConstraintLayout(getContext(), null);
        cl1.setId(View.generateViewId());
        cl1.setBackgroundColor(Color.BLUE);
        addView(cl1);
        cl1Cs = new ConstraintSet();
        cl1Cs.constrainWidth(
                cl1.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        cl1Cs.constrainHeight(
                cl1.getId(),
                vHeightDp);
        cl1Cs.connect(
                cl1.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(0, getContext()));
        cl1Cs.connect(
                cl1.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(0, getContext()));
        cl1Cs.connect(
                cl1.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(0, getContext()));
        cl1Cs.applyTo(this);
        Button sampleBtn = new Button(getContext());
        sampleBtn.setId(View.generateViewId());
        sampleBtn.setText("sample");
        sampleBtn.setBackgroundColor(Color.GRAY);
        sampleBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(MenuOrderBottomView.class.getSimpleName(), "sampleBtn clicked.");
            }
        });
        cl1.addView(sampleBtn);
        ConstraintSet sampleBtnCs = new ConstraintSet();
        sampleBtnCs.constrainWidth(
                sampleBtn.getId(),
                ConstraintSet.WRAP_CONTENT);
        sampleBtnCs.constrainHeight(
                sampleBtn.getId(),
                ConstraintSet.WRAP_CONTENT);
        sampleBtnCs.centerHorizontally(
                sampleBtn.getId(),
                ConstraintSet.PARENT_ID);
        sampleBtnCs.centerVertically(
                sampleBtn.getId(),
                ConstraintSet.PARENT_ID);
        sampleBtnCs.applyTo(cl1);

        ConstraintLayout cl2 = new ConstraintLayout(getContext(), null);
        cl2.setId(View.generateViewId());
        cl2.setBackgroundColor(Color.GREEN);
        addView(cl2);
        ConstraintSet cl2Cs = new ConstraintSet();
        cl2Cs.constrainWidth(
                cl2.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        cl2Cs.constrainHeight(
                cl2.getId(),
                DpPx.convertDp2Px(50, getContext()));
        cl2Cs.connect(
                cl2.getId(),
                ConstraintSet.TOP,
                cl1.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(0, getContext()));
        cl2Cs.connect(
                cl2.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(0, getContext()));
        cl2Cs.connect(
                cl2.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(0, getContext()));
        cl2Cs.connect(
                cl2.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(0, getContext()));
        cl2Cs.applyTo(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int currentY = (int) motionEvent.getRawY();
        int diffY;
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                pressedY = currentY;
                break;
            case MotionEvent.ACTION_MOVE:
                diffY = currentY - pressedY;
                pressedY = currentY;

                if (vHeightDp - diffY > HEIGHT_DP_MAX) {
                    break;
                }
                vHeightDp -= diffY;
                cl1Cs.constrainHeight(
                        cl1.getId(),
                        vHeightDp);
                cl1Cs.applyTo(this);

                break;
            case MotionEvent.ACTION_UP:
                diffY = currentY - pressedY;

                vHeightDp -= diffY;

                if (vOpenFlg && vHeightDp > HEIGHT_DP_TAP_MAX) {
                    // 本ビューが開いている状態で、タップされた場合。
                    vHeightDp = HEIGHT_DP_MIN;
                    vOpenFlg = false;
                } else if (!vOpenFlg && vHeightDp < HEIGHT_DP_TAP_MIN) {
                    // 本ビューが閉じている状態で、タップされた場合。
                    vHeightDp = HEIGHT_DP_MAX;
                    vOpenFlg = true;
                } else {
                    // 本ビューがスライドされている場合。
                    if (vHeightDp > HEIGHT_DP_THRESHOLD) {
                        vHeightDp = HEIGHT_DP_MAX;
                        vOpenFlg = true;
                    } else {
                        vHeightDp = HEIGHT_DP_MIN;
                        vOpenFlg = false;
                    }
                }
                cl1Cs.constrainHeight(
                        cl1.getId(),
                        vHeightDp);
                TransitionManager.beginDelayedTransition(this);
                cl1Cs.applyTo(this);

                break;
        }
        return true;
    }

}
