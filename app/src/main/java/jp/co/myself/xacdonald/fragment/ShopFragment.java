package jp.co.myself.xacdonald.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import jp.co.myself.xacdonald.activity.MainActivity;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.utils.DpPx;
import jp.co.myself.xacdonald.utils.StringUtils;
import jp.co.myself.xacdonald.view.common.TitleSubHeader;
import jp.co.myself.xacdonald.view.shop.OrderMenuView;

public class ShopFragment extends Fragment {

    private MenuItem menuItem;

    public ShopFragment() {
        // Required empty public constructor
    }

    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuItem = ShopFragmentArgs.fromBundle(getArguments()).getMenuItem();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConstraintLayout cl = new ConstraintLayout(getContext());

        TitleSubHeader th = new TitleSubHeader(getContext());
        th.setId(View.generateViewId());
        SpannableStringBuilder titleSsb = new SpannableStringBuilder();
        titleSsb.append("どちらの店舗で受け取りますか");
        titleSsb.setSpan(
                new AbsoluteSizeSpan(16, true),
                0,
                titleSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSsb.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                titleSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        th.titleTv.setText(titleSsb);
        th.subTitleTv.setText("店舗によりお取り扱いの無い商品がある場合があります。");
        th.setDelegate(new TitleSubHeader.TitleHeaderDelegate() {
            @Override
            public void tapLeftBtn() {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.popBackStackForFragment();
            }
        });
        cl.addView(th);
        ConstraintSet thCs = new ConstraintSet();
        thCs.constrainWidth(
                th.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        thCs.constrainHeight(
                th.getId(),
                ConstraintSet.WRAP_CONTENT);
        thCs.connect(
                th.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(0, getContext()));
        thCs.connect(
                th.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(0, getContext()));
        thCs.connect(
                th.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(0, getContext()));
        thCs.applyTo(cl);

        OrderMenuView omv = new OrderMenuView(getContext());
        omv.setId(View.generateViewId());
        Glide
                .with(omv.imageView)
                .load(menuItem.getImgUrl())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(omv.imageView);
        omv.nameTv.setText(menuItem.getName());
        omv.priceTv.setText(StringUtils.getPriceStringWithLabel(
                16,
                22,
                menuItem.getPrice(),
                "",
                16));
        cl.addView(omv);
        ConstraintSet omvCs = new ConstraintSet();
        omvCs.constrainWidth(
                omv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        omvCs.constrainHeight(
                omv.getId(),
                ConstraintSet.WRAP_CONTENT);
        omvCs.connect(
                omv.getId(),
                ConstraintSet.TOP,
                th.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, getContext()));
        omvCs.connect(
                omv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(5, getContext()));
        omvCs.connect(
                omv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(5, getContext()));
        omvCs.applyTo(cl);

        return cl;
    }
}
