package jp.co.myself.xacdonald.view.home;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class HighScoreItemView extends ConstraintLayout {

    public ImageView imageView;
    public TextView nameTv;
    public TextView priceTv;

    public HighScoreItemView(@NonNull Context context) {
        super(context);

        setBackgroundColor(Color.CYAN);

        imageView = new ImageView(context);
        imageView.setId(View.generateViewId());
        addView(imageView);
        ConstraintSet imageViewCs = new ConstraintSet();
        imageViewCs.constrainWidth(
                imageView.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        imageViewCs.constrainHeight(
                imageView.getId(),
                ConstraintSet.WRAP_CONTENT);
        imageViewCs.connect(
                imageView.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                5);
        imageViewCs.connect(
                imageView.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        imageViewCs.connect(
                imageView.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                5);
        imageViewCs.applyTo(this);

        nameTv = new TextView(context);
        nameTv.setId(View.generateViewId());
        nameTv.setMinLines(3);
        nameTv.setMaxLines(3);
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
                imageView.getId(),
                //ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                //ConstraintSet.TOP,
                5);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
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
                5);
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                5);
        priceTvCs.applyTo(this);

    }
}
