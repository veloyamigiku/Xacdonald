package jp.co.myself.xacdonald.utils;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;

public class StringUtils {

    public static SpannableStringBuilder getPriceString(int unitSizeDp, int priceSizeDp, int price) {
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        int start = ssb.length();
        ssb.append("¥");
        ssb.setSpan(
                new AbsoluteSizeSpan(unitSizeDp, true),
                start,
                ssb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(
                new StyleSpan(Typeface.BOLD),
                start,
                ssb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        start = ssb.length();
        ssb.append(String.valueOf(price));
        ssb.setSpan(
                new AbsoluteSizeSpan(priceSizeDp, true),
                start,
                ssb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(
                new StyleSpan(Typeface.BOLD),
                start,
                ssb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

}
