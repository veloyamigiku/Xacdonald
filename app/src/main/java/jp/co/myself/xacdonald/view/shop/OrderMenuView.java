package jp.co.myself.xacdonald.view.shop;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import jp.co.myself.xacdonald.utils.DpPx;

public class OrderMenuView extends ConstraintLayout {

    public ImageView imageView;
    public TextView nameTv;
    public TextView priceTv;

    public OrderMenuView(@NonNull Context context) {
        super(context);

        imageView = new ImageView(context);
        imageView.setId(View.generateViewId());
        addView(imageView);
        ConstraintSet imageViewCs = new ConstraintSet();
        imageViewCs.constrainWidth(
                imageView.getId(),
                DpPx.convertDp2Px(50, context));
        imageViewCs.constrainHeight(
                imageView.getId(),
                DpPx.convertDp2Px(50, context));
        imageViewCs.connect(
                imageView.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(10, context));
        imageViewCs.connect(
                imageView.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(10, context));
        imageViewCs.connect(
                imageView.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(10, context));
        imageViewCs.applyTo(this);

        nameTv = new TextView(context);
        nameTv.setId(View.generateViewId());
        nameTv.setLines(1);
        nameTv.setEllipsize(TextUtils.TruncateAt.END);
        addView(nameTv);
        ConstraintSet nameTvCs = new ConstraintSet();
        nameTvCs.constrainWidth(
                nameTv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        nameTvCs.constrainHeight(
                nameTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(5, context));
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.LEFT,
                imageView.getId(),
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(10, context));
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(10, context));
        nameTvCs.applyTo(this);

        priceTv = new TextView(context);
        priceTv.setId(View.generateViewId());
        addView(priceTv);
        ConstraintSet priceTvCs = new ConstraintSet();
        priceTvCs.constrainWidth(
                priceTv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        priceTvCs.constrainHeight(
                priceTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.TOP,
                nameTv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, context));
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.LEFT,
                imageView.getId(),
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(10, context));
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(10, context));
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, context));
        priceTvCs.applyTo(this);
    }
}
