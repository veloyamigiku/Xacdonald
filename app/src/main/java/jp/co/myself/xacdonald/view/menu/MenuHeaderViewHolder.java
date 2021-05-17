package jp.co.myself.xacdonald.view.menu;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class MenuHeaderViewHolder extends RecyclerView.ViewHolder {

    public TextView labelTv;

    public MenuHeaderViewHolder(@NonNull View itemView, Map<String, Integer> uiIDResIDMap) {
        super(itemView);

        labelTv = itemView.findViewById(uiIDResIDMap.get(MenuHeaderViewCreator.ID_LABEL));
    }

}
