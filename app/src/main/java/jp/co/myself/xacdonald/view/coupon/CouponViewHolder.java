package jp.co.myself.xacdonald.view.coupon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class CouponViewHolder extends RecyclerView.ViewHolder {

    ImageView imgIv;
    TextView nameTv;
    TextView priceTv;

    public CouponViewHolder(@NonNull View itemView, Map<String, Integer> uiIDResIDMap) {
        super(itemView);

        imgIv = itemView.findViewById(uiIDResIDMap.get(CouponViewCreator.ID_IMG));
        nameTv = itemView.findViewById(uiIDResIDMap.get(CouponViewCreator.ID_NAME));
        priceTv = itemView.findViewById(uiIDResIDMap.get(CouponViewCreator.ID_PRICE));

    }
}
