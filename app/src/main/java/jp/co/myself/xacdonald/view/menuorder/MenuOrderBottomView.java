package jp.co.myself.xacdonald.view.menuorder;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.TransitionManager;

import jp.co.myself.xacdonald.utils.DpPx;

public class MenuOrderBottomView extends ConstraintLayout implements View.OnTouchListener {

    private ConstraintSet vCs;
    private View v;
    private int vHeightDp = DpPx.convertDp2Px(50, getContext());
    private final int vHeightDpMax = DpPx.convertDp2Px(150, getContext());
    private final int vHeightDpTapMax = DpPx.convertDp2Px(140, getContext());
    private final int vHeightDpThres = DpPx.convertDp2Px(100, getContext());
    private final int vHeightDpMin = DpPx.convertDp2Px(50, getContext());
    private final int vHeightDpTapMin = DpPx.convertDp2Px(60, getContext());
    private int pressedx;
    private int pressedy;

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
        int currentx = (int) motionEvent.getRawX();
        int currenty = (int) motionEvent.getRawY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(MenuOrderBottomView.class.getSimpleName(), "Down");
                pressedx = currentx;
                pressedy = currenty;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(MenuOrderBottomView.class.getSimpleName(), "Move");
                int diffx = currentx - pressedx;
                int diffy = currenty - pressedy;
                pressedx = currentx;
                pressedy = currenty;

                vHeightDp -= diffy;
                vCs.constrainHeight(
                        v.getId(),
                        vHeightDp);
                vCs.applyTo(this);

                Log.d(MenuOrderBottomView.class.getSimpleName(), diffx + "," + diffy);
                break;
            case MotionEvent.ACTION_UP:
                Log.d(MenuOrderBottomView.class.getSimpleName(), "Up");
                int diffx2 = currentx - pressedx;
                int diffy2 = currenty - pressedy;

                vHeightDp -= diffy2;
                if (vHeightDp > vHeightDpThres) {
                    vHeightDp = vHeightDpMax;
                } else {
                    vHeightDp = vHeightDpMin;
                }
                vCs.constrainHeight(
                        v.getId(),
                        vHeightDp);
                TransitionManager.beginDelayedTransition(this);
                vCs.applyTo(this);

                Log.d(MenuOrderBottomView.class.getSimpleName(), diffx2 + "," + diffy2);
                break;
        }
        return true;
    }

}
