package jp.co.myself.xacdonald.utils;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;

public class StringUtils {

    public static SpannableStringBuilder getPriceStringWithLabel(
            int unitSizeDp,
            int priceSizeDp,
            int price,
            String label,
            int labelSizeDp) {
        SpannableStringBuilder ssbPrice = getPriceString(unitSizeDp, priceSizeDp, price);
        SpannableStringBuilder ssbLabel = new SpannableStringBuilder();
        ssbLabel.append(label);
        ssbLabel.setSpan(
                new AbsoluteSizeSpan(labelSizeDp, true),
                0,
                ssbLabel.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssbPrice.insert(0, ssbLabel);
    }

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
