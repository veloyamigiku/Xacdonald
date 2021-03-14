package jp.co.myself.xacdonald.view.home;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class LowPriceItemViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public LowPriceItemViewHolder(@NonNull View view, Map<String, Integer> uiIdViewIdMap) {
        super(view);

        imageView = view.findViewById(uiIdViewIdMap.get(LowPriceItemViewCreator.ID_IMAGE));
    }


}
