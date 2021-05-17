package jp.co.myself.xacdonald.view.menu;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class MenuItemViewCreator {

    public static final String ID_NAME = "name";
    public static final String ID_IMG = "img";
    public static final String ID_PRICE = "price";

    public static TableViewCreatorResult create(Context context, int parentWidth) {

        Map<String, Integer> uiIDViewIDMap = new HashMap<>();

        ConstraintLayout cl = new ConstraintLayout(context);
        cl.setLayoutParams(new Constraints.LayoutParams(
                parentWidth / 2,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        ImageView img = new ImageView(context);
        img.setId(View.generateViewId());
        uiIDViewIDMap.put(ID_IMG, img.getId());
        cl.addView(img);
        ConstraintSet imgCs = new ConstraintSet();
        imgCs.constrainWidth(
                img.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        imgCs.constrainHeight(
                img.getId(),
                ConstraintSet.WRAP_CONTENT);
        imgCs.connect(
                img.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                5);
        imgCs.connect(
                img.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        imgCs.connect(
                img.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                5);
        imgCs.applyTo(cl);

        TextView name = new TextView(context);
        name.setId(View.generateViewId());
        name.setGravity(Gravity.LEFT);
        name.setLines(3);
        name.setEllipsize(TextUtils.TruncateAt.END);
        uiIDViewIDMap.put(ID_NAME, name.getId());
        cl.addView(name);
        ConstraintSet nameCs = new ConstraintSet();
        nameCs.constrainHeight(
                name.getId(),
                ConstraintSet.WRAP_CONTENT);
        nameCs.connect(
                name.getId(),
                ConstraintSet.TOP,
                img.getId(),
                ConstraintSet.BOTTOM,
                5);
        nameCs.connect(
                name.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        nameCs.connect(
                name.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                5);
        nameCs.applyTo(cl);

        TextView price = new TextView(context);
        price.setId(View.generateViewId());
        uiIDViewIDMap.put(ID_PRICE, price.getId());
        cl.addView(price);
        ConstraintSet priceCs = new ConstraintSet();
        priceCs.constrainHeight(
                price.getId(),
                ConstraintSet.WRAP_CONTENT);
        priceCs.connect(
                price.getId(),
                ConstraintSet.TOP,
                name.getId(),
                ConstraintSet.BOTTOM,
                5);
        priceCs.connect(
                price.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        priceCs.connect(
                price.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                5);
        priceCs.applyTo(cl);

        return new TableViewCreatorResult(cl, uiIDViewIDMap);
    }
}
