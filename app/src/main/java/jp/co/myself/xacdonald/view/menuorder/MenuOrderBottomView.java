package jp.co.myself.xacdonald.view.menuorder;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.TransitionManager;

import jp.co.myself.xacdonald.utils.DpPx;

public class MenuOrderBottomView extends ConstraintLayout implements View.OnTouchListener {

    private final int HEIGHT_DP_MAX = DpPx.convertDp2Px(150, getContext());
    private final int HEIGHT_DP_TAP_MAX = DpPx.convertDp2Px(149, getContext());
    private final int HEIGHT_DP_THRESHOLD = DpPx.convertDp2Px(100, getContext());
    private final int HEIGHT_DP_MIN = DpPx.convertDp2Px(50, getContext());
    private final int HEIGHT_DP_TAP_MIN = DpPx.convertDp2Px(51, getContext());

    private ConstraintSet vCs;
    private View v;
    private int vHeightDp = DpPx.convertDp2Px(50, getContext());
    private boolean vOpenFlg = false;
    private int pressedY;

    public MenuOrderBottomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(Color.GRAY);

        v = new View(context);
        v.setId(View.generateViewId());
        v.setBackgroundColor(Color.MAGENTA);
        addView(v);
        vCs = new ConstraintSet();
        vCs.constrainWidth(
                v.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        vCs.constrainHeight(
                v.getId(),
                vHeightDp);
        vCs.applyTo(this);
        setOnTouchListener(this);
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

                vHeightDp -= diffY;
                vCs.constrainHeight(
                        v.getId(),
                        vHeightDp);
                vCs.applyTo(this);

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
                vCs.constrainHeight(
                        v.getId(),
                        vHeightDp);
                TransitionManager.beginDelayedTransition(this);
                vCs.applyTo(this);

                break;
        }
        return true;
    }

}
