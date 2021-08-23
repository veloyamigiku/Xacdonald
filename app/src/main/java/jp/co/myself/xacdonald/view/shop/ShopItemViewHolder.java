package jp.co.myself.xacdonald.view.shop;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class ShopItemViewHolder extends RecyclerView.ViewHolder {

    TextView tv;

    public ShopItemViewHolder(@NonNull View itemView, Map<String, Integer> uiIDResIDMap) {
        super(itemView);

        tv = itemView.findViewById(uiIDResIDMap.get(ShopItemViewCreator.ID_TV));

    }

}
