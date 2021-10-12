package jp.co.myself.xacdonald.view.menuorder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class MenuOrderHeaderViewHolder extends RecyclerView.ViewHolder {

    public TextView labelTv;


    public MenuOrderHeaderViewHolder(@NonNull View itemView, Map<String, Integer> uiIDResIDMap) {
        super(itemView);

        labelTv = itemView.findViewById(uiIDResIDMap.get(MenuOrderHeaderViewCreator.ID_LABEL));
    }
}
