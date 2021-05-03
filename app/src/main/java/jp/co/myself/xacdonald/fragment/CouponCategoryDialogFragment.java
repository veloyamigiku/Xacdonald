package jp.co.myself.xacdonald.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;

public class CouponCategoryDialogFragment extends DialogFragment {

    private String name;

    private String detail;

    public CouponCategoryDialogFragment() {}

    public CouponCategoryDialogFragment(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        ConstraintLayout cl = new ConstraintLayout(getContext());
        View topColorBar = new View(getContext());
        topColorBar.setId(View.generateViewId());
        topColorBar.setBackgroundColor(Color.parseColor("#FFA500"));
        cl.addView(topColorBar);
        ConstraintSet topColorBarCs = new ConstraintSet();
        topColorBarCs.constrainWidth(
                topColorBar.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        topColorBarCs.constrainHeight(
                topColorBar.getId(),
                25);
        topColorBarCs.connect(
                topColorBar.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);
        topColorBarCs.connect(
                topColorBar.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        topColorBarCs.connect(
                topColorBar.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        topColorBarCs.applyTo(cl);

        TextView nameTv = new TextView(getContext());
        nameTv.setId(View.generateViewId());
        nameTv.setText(name);
        nameTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        nameTv.setTypeface(Typeface.DEFAULT_BOLD);
        cl.addView(nameTv);
        ConstraintSet nameTvCs = new ConstraintSet();
        nameTvCs.constrainHeight(
                nameTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.TOP,
                topColorBar.getId(),
                ConstraintSet.BOTTOM,
                130);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                80);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                80);
        nameTvCs.applyTo(cl);

        TextView detailTv = new TextView(getContext());
        detailTv.setId(View.generateViewId());
        detailTv.setText(detail);
        detailTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        cl.addView(detailTv);
        ConstraintSet detailTvCs = new ConstraintSet();
        detailTvCs.constrainHeight(
                detailTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        detailTvCs.connect(
                detailTv.getId(),
                ConstraintSet.TOP,
                nameTv.getId(),
                ConstraintSet.BOTTOM,
                130);
        detailTvCs.connect(
                detailTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                80);
        detailTvCs.connect(
                detailTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                80);
        detailTvCs.connect(
                detailTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                80);
        detailTvCs.applyTo(cl);

        builder.setView(cl);

        return builder.create();
    }
}
