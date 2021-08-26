package jp.co.myself.xacdonald.view.shop;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShopItemDecoration extends RecyclerView.ItemDecoration {

    private int marginLeft;
    private int marginTop;
    private int marginRight;
    private int marginBottom;

    public ShopItemDecoration(
            int marginLeft,
            int marginTop,
            int marginRight,
            int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left = marginLeft;
        outRect.top = marginTop;
        outRect.right = marginRight;
        outRect.bottom = marginBottom;
    }

}
