package jp.co.myself.xacdonald.view.coupon;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class CouponViewCreator {

    public static final String ID_NAME = "name";

    public static final String ID_PRICE = "price";

    public static final String ID_IMG = "img";

    public static TableViewCreatorResult create(Context context, int parentWidth) {

        Map<String, Integer> uiIDViewIDMap = new HashMap<>();

        ConstraintLayout cl = new ConstraintLayout(context);

        ImageView imgIv = new ImageView(context);
        imgIv.setId(View.generateViewId());
        uiIDViewIDMap.put(ID_IMG, imgIv.getId());
        cl.addView(imgIv);
        ConstraintSet imgIvCs = new ConstraintSet();
        imgIvCs.constrainWidth(
                imgIv.getId(),
                parentWidth);
        imgIvCs.constrainHeight(
                imgIv.getId(),
                ConstraintSet.WRAP_CONTENT);
        imgIvCs.connect(
                imgIv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);
        imgIvCs.connect(
                imgIv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        imgIvCs.connect(
                imgIv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        imgIvCs.applyTo(cl);

        TextView nameTv = new TextView(context);
        nameTv.setId(View.generateViewId());
        nameTv.setEllipsize(TextUtils.TruncateAt.END);
        nameTv.setMaxLines(3);
        nameTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        nameTv.setTypeface(Typeface.DEFAULT_BOLD);
        uiIDViewIDMap.put(ID_NAME, nameTv.getId());
        cl.addView(nameTv);
        ConstraintSet nameTvCs = new ConstraintSet();
        nameTvCs.constrainHeight(
                nameTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.TOP,
                imgIv.getId(),
                ConstraintSet.BOTTOM,
                30);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                40);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                40);
        nameTvCs.applyTo(cl);

        TextView detailTv = new TextView(context);
        detailTv.setId(View.generateViewId());
        detailTv.setText("詳細");
        detailTv.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        detailTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "詳細タップ", Toast.LENGTH_LONG).show();
            }
        });
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
                30);
        detailTvCs.connect(
                detailTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                40);
        detailTvCs.applyTo(cl);

        TextView priceLabelTv = new TextView(context);
        priceLabelTv.setText("クーポン価格");
        priceLabelTv.setId(View.generateViewId());
        priceLabelTv.setGravity(Gravity.BOTTOM);
        priceLabelTv.setBackgroundColor(Color.CYAN);
        cl.addView(priceLabelTv);
        ConstraintSet priceLabelTvCs = new ConstraintSet();
        priceLabelTvCs.constrainWidth(
                priceLabelTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        priceLabelTvCs.connect(
                priceLabelTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                40);

        TextView priceUnitLabel = new TextView(context);
        priceUnitLabel.setId(View.generateViewId());
        priceUnitLabel.setText("¥");
        priceUnitLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        priceUnitLabel.setTypeface(Typeface.DEFAULT_BOLD);
        priceUnitLabel.setGravity(Gravity.BOTTOM);
        cl.addView(priceUnitLabel);
        ConstraintSet priceUnitLabelCs = new ConstraintSet();
        priceUnitLabelCs.constrainWidth(
                priceUnitLabel.getId(),
                ConstraintSet.WRAP_CONTENT);
        priceUnitLabelCs.connect(
                priceUnitLabel.getId(),
                ConstraintSet.LEFT,
                priceLabelTv.getId(),
                ConstraintSet.RIGHT,
                10);

        TextView priceTv = new TextView(context);
        priceTv.setId(View.generateViewId());
        uiIDViewIDMap.put(ID_PRICE, priceTv.getId());
        //priceTv.setText("6,700");
        priceTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        priceTv.setTypeface(Typeface.DEFAULT_BOLD);
        priceTv.setBackgroundColor(Color.YELLOW);
        cl.addView(priceTv);
        ConstraintSet priceTvCs = new ConstraintSet();
        priceTvCs.constrainHeight(
                priceTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.TOP,
                detailTv.getId(),
                ConstraintSet.BOTTOM,
                30);
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.LEFT,
                priceLabelTv.getId(),
                ConstraintSet.RIGHT,
                50);
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                30);
        priceTvCs.applyTo(cl);

        priceLabelTvCs.connect(
                priceLabelTv.getId(),
                ConstraintSet.TOP,
                priceTv.getId(),
                ConstraintSet.TOP);
        priceLabelTvCs.connect(
                priceLabelTv.getId(),
                ConstraintSet.BOTTOM,
                priceTv.getId(),
                ConstraintSet.BOTTOM,
                10);
        priceLabelTvCs.applyTo(cl);

        priceUnitLabelCs.connect(
                priceUnitLabel.getId(),
                ConstraintSet.TOP,
                priceTv.getId(),
                ConstraintSet.TOP);
        priceUnitLabelCs.connect(
                priceUnitLabel.getId(),
                ConstraintSet.BOTTOM,
                priceTv.getId(),
                ConstraintSet.BOTTOM,
                10);
        priceUnitLabelCs.applyTo(cl);

        return new TableViewCreatorResult(cl, uiIDViewIDMap);
    }

}
