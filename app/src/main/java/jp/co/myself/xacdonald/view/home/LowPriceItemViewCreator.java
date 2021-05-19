package jp.co.myself.xacdonald.view.home;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class LowPriceItemViewCreator {

    public static final String ID_IMAGE = "Image";

    public static TableViewCreatorResult create(Context context, int parentWidth) {

        Map<String, Integer> uiIdViewIdMap = new HashMap<>();
        ConstraintLayout cs = new ConstraintLayout(context);
        cs.setBackgroundColor(Color.CYAN);
        cs.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT));
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) cs.getLayoutParams();
        mlp.setMargins(10, 10, 10, 10);

        ImageView imageView = new ImageView(context);
        imageView.setId(View.generateViewId());
        uiIdViewIdMap.put(ID_IMAGE, imageView.getId());
        cs.addView(imageView);
        ConstraintSet imageViewCs = new ConstraintSet();
        imageViewCs.constrainHeight(
                imageView.getId(),
                parentWidth);
        imageViewCs.connect(
                imageView.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);
        imageViewCs.connect(
                imageView.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        imageViewCs.connect(
                imageView.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        imageViewCs.applyTo(cs);

        return new TableViewCreatorResult(cs, uiIdViewIdMap);

    }

}
