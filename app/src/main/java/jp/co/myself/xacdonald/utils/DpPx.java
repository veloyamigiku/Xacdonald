package jp.co.myself.xacdonald.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class DpPx {
    public static int convertDp2Px(int dp, Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int)(dp * metrics.density);
    }
}
