package jp.co.myself.xacdonald.view.shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.HashMap;
import java.util.Map;

import jp.co.myself.xacdonald.utils.DpPx;
import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class ShopItemViewCreator {

    public static final String ID_STATUS = "shop_status";
    public static final String ID_DISTANCE = "distance";
    public static final String ID_NAME = "name";
    public static final String ID_ADDRESS = "address";
    public static final String ID_STATION = "station";
    public static final String ID_RAILWAY = "railway";

    public static TableViewCreatorResult create(
            Context context) {

        Map<String, Integer> uiIDResIDMap = new HashMap<>();

        ConstraintLayout cl = new ConstraintLayout(context);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));


        TextView statusTv = new TextView(context);
        statusTv.setId(View.generateViewId());
        uiIDResIDMap.put(ID_STATUS, statusTv.getId());
        cl.addView(statusTv);
        ConstraintSet statusTvCs = new ConstraintSet();
        statusTvCs.constrainHeight(
                statusTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        statusTvCs.connect(
                statusTv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(10, context));
        statusTvCs.connect(
                statusTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(10, context));
        statusTvCs.applyTo(cl);

        TextView distanceTv = new TextView(context);
        distanceTv.setId(View.generateViewId());
        uiIDResIDMap.put(ID_DISTANCE, distanceTv.getId());
        cl.addView(distanceTv);
        ConstraintSet distanceTvCs = new ConstraintSet();
        distanceTvCs.constrainHeight(
                distanceTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        distanceTvCs.connect(
                distanceTv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(10, context));
        distanceTvCs.connect(
                distanceTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(10, context));
        distanceTvCs.applyTo(cl);

        TextView nameTv = new TextView(context);
        nameTv.setId(View.generateViewId());
        uiIDResIDMap.put(ID_NAME, nameTv.getId());
        cl.addView(nameTv);
        ConstraintSet nameTvCs = new ConstraintSet();
        nameTvCs.constrainHeight(
                nameTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.TOP,
                statusTv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(10, context));
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(10, context));
        nameTvCs.applyTo(cl);

        TextView addressTv = new TextView(context);
        addressTv.setId(View.generateViewId());
        uiIDResIDMap.put(ID_ADDRESS, addressTv.getId());
        cl.addView(addressTv);
        ConstraintSet addressTvCs = new ConstraintSet();
        addressTvCs.constrainHeight(
                addressTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        addressTvCs.connect(
                addressTv.getId(),
                ConstraintSet.TOP,
                nameTv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(10, context));
        addressTvCs.connect(
                addressTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(10, context));
        addressTvCs.applyTo(cl);

        TextView stationTv = new TextView(context);
        stationTv.setId(View.generateViewId());
        uiIDResIDMap.put(ID_STATION, stationTv.getId());
        cl.addView(stationTv);
        ConstraintSet stationTvCs = new ConstraintSet();
        stationTvCs.constrainHeight(
                stationTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        stationTvCs.connect(
                stationTv.getId(),
                ConstraintSet.TOP,
                addressTv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(10, context));
        stationTvCs.connect(
                stationTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(10, context));
        stationTvCs.applyTo(cl);

        TextView railwayTv = new TextView(context);
        railwayTv.setId(View.generateViewId());
        uiIDResIDMap.put(ID_RAILWAY, railwayTv.getId());
        cl.addView(railwayTv);
        ConstraintSet railwayTvCs = new ConstraintSet();
        railwayTvCs.constrainHeight(
                railwayTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        railwayTvCs.connect(
                railwayTv.getId(),
                ConstraintSet.TOP,
                stationTv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(10, context));
        railwayTvCs.connect(
                railwayTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(10, context));
        railwayTvCs.connect(
                railwayTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(10, context));
        railwayTvCs.applyTo(cl);

        return new TableViewCreatorResult(
                cl,
                uiIDResIDMap);

    }
}
