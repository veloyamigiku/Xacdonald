package jp.co.myself.xacdonald.view.menu;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class MenuItemViewHolder extends RecyclerView.ViewHolder {

    public ImageView imgIv;
    public TextView nameTv;
    public TextView priceTv;

    public MenuItemViewHolder(@NonNull View itemView, Map<String, Integer> uiIDResIDMap) {
        super(itemView);

        imgIv = itemView.findViewById(uiIDResIDMap.get(MenuItemViewCreator.ID_IMG));
        nameTv = itemView.findViewById(uiIDResIDMap.get(MenuItemViewCreator.ID_NAME));
        priceTv = itemView.findViewById(uiIDResIDMap.get(MenuItemViewCreator.ID_PRICE));
    }
}
