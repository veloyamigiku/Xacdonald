package jp.co.myself.xacdonald.view.menuinfodetail;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class MenuInfoDetailItemViewHolder extends RecyclerView.ViewHolder {

    public TextView labelTv;

    public TextView valueTv;

    public MenuInfoDetailItemViewHolder(@NonNull View itemView, Map<String, Integer> uiIDResIDMap) {
        super(itemView);

        labelTv = itemView.findViewById(uiIDResIDMap.get(MenuInfoDetailItemViewCreator.ID_LABEL));
        valueTv = itemView.findViewById(uiIDResIDMap.get(MenuInfoDetailItemViewCreator.ID_VALUE));
    }

}
