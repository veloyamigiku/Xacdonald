package jp.co.myself.xacdonald.view.menuorder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class MenuOrderItemViewHolder extends RecyclerView.ViewHolder {

    public ImageView imgIv;
    public TextView nameTv;
    public TextView priceTv;

    public MenuOrderItemViewHolder(@NonNull View itemView, Map<String, Integer> uiIDResIDMap) {
        super(itemView);

        imgIv = itemView.findViewById(uiIDResIDMap.get(MenuOrderItemViewCreator.ID_IMG));
        nameTv = itemView.findViewById(uiIDResIDMap.get(MenuOrderItemViewCreator.ID_NAME));
        priceTv = itemView.findViewById(uiIDResIDMap.get(MenuOrderItemViewCreator.ID_PRICE));
    }
}
