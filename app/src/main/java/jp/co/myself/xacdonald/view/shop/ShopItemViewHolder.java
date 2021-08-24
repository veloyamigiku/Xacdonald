package jp.co.myself.xacdonald.view.shop;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class ShopItemViewHolder extends RecyclerView.ViewHolder {

    TextView statusTv;
    TextView distanceTv;
    TextView nameTv;
    TextView addressTv;
    TextView stationTv;
    TextView railwayTv;

    public ShopItemViewHolder(@NonNull View itemView, Map<String, Integer> uiIDResIDMap) {
        super(itemView);

        statusTv = itemView.findViewById(uiIDResIDMap.get(ShopItemViewCreator.ID_STATUS));
        distanceTv = itemView.findViewById(uiIDResIDMap.get(ShopItemViewCreator.ID_DISTANCE));
        nameTv = itemView.findViewById(uiIDResIDMap.get(ShopItemViewCreator.ID_NAME));
        addressTv = itemView.findViewById(uiIDResIDMap.get(ShopItemViewCreator.ID_ADDRESS));
        stationTv = itemView.findViewById(uiIDResIDMap.get(ShopItemViewCreator.ID_STATION));
        railwayTv = itemView.findViewById(uiIDResIDMap.get(ShopItemViewCreator.ID_RAILWAY));

    }

}
