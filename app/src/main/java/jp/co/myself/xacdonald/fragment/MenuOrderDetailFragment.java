package jp.co.myself.xacdonald.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import jp.co.myself.xacdonald.activity.MainActivity;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.utils.DpPx;
import jp.co.myself.xacdonald.utils.StringUtils;
import jp.co.myself.xacdonald.view.common.BaseTitleHeader;
import jp.co.myself.xacdonald.view.common.TitleHeader;
import jp.co.myself.xacdonald.view.menuorder.PlusMinusCounter;

public class MenuOrderDetailFragment extends Fragment implements PlusMinusCounter.PlusMinusCounterDelegate {

    private MenuItem menuItem;

    private TextView priceTv;

    public MenuOrderDetailFragment() {
        // Required empty public constructor
    }

    public static MenuOrderDetailFragment newInstance(String param1, String param2) {
        MenuOrderDetailFragment fragment = new MenuOrderDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuItem = MenuOrderDetailFragmentArgs.fromBundle(getArguments()).getMenuItem();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConstraintLayout cl = new ConstraintLayout(getContext());

        TitleHeader th = new TitleHeader(getContext(), null);
        th.setId(View.generateViewId());
        SpannableStringBuilder titleSsb = new SpannableStringBuilder();
        titleSsb.append(menuItem.getName());
        titleSsb.setSpan(
                new AbsoluteSizeSpan(16, true),
                0,
                menuItem.getName().length(),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSsb.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                menuItem.getName().length(),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        th.titleTv.setText(titleSsb);
        th.setDelegate(new BaseTitleHeader.TitleHeaderDelegate() {
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

        ScrollView sv = new ScrollView(getContext());
        sv.setId(View.generateViewId());
        sv.setBackgroundColor(Color.CYAN);
        cl.addView(sv);
        ConstraintSet svCs = new ConstraintSet();
        svCs.constrainWidth(
                sv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        svCs.constrainHeight(
                sv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        svCs.connect(
                sv.getId(),
                ConstraintSet.TOP,
                th.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(0, getContext()));
        svCs.connect(
                sv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(0, getContext()));
        svCs.connect(
                sv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(0, getContext()));
        svCs.connect(
                sv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(0, getContext()));
        svCs.applyTo(cl);

        ConstraintLayout svCl = new ConstraintLayout(getContext());
        svCl.setId(View.generateViewId());
        svCl.setBackgroundColor(Color.MAGENTA);
        sv.addView(svCl);
        ConstraintSet svClCs = new ConstraintSet();
        svClCs.constrainWidth(
                svCl.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        svClCs.constrainHeight(
                svCl.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        svClCs.applyTo(cl);

        ImageView imageIv = new ImageView(getContext());
        imageIv.setId(View.generateViewId());
        Glide
                .with(imageIv)
                .load(menuItem.getImgUrl())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(imageIv);
        svCl.addView(imageIv);
        ConstraintSet imageIvCs = new ConstraintSet();
        imageIvCs.constrainWidth(
                imageIv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        imageIvCs.constrainHeight(
                imageIv.getId(),
                ConstraintSet.WRAP_CONTENT);
        imageIvCs.connect(
                imageIv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                DpPx.convertDp2Px(5, getContext()));
        imageIvCs.connect(
                imageIv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(5, getContext()));
        imageIvCs.connect(
                imageIv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(5, getContext()));
        imageIvCs.applyTo(svCl);

        TextView descTv = new TextView(getContext());
        descTv.setId(View.generateViewId());
        descTv.setText(menuItem.getDescription());
        svCl.addView(descTv);
        ConstraintSet descTvCs = new ConstraintSet();
        descTvCs.constrainWidth(
                descTv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        descTvCs.constrainHeight(
                descTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        descTvCs.connect(
                descTv.getId(),
                ConstraintSet.TOP,
                imageIv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, getContext()));
        descTvCs.connect(
                descTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(5, getContext()));
        descTvCs.connect(
                descTv.getId(),
                ConstraintSet.RIGHT,
                imageIv.getId(),
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(5, getContext()));
        descTvCs.applyTo(svCl);

        TextView infoDetailTv = new TextView(getContext());
        infoDetailTv.setId(View.generateViewId());
        SpannableStringBuilder infoDetailSsb = new SpannableStringBuilder();
        infoDetailSsb.append("商品情報詳細");
        infoDetailSsb.setSpan(
                new UnderlineSpan(),
                0,
                infoDetailSsb.length(),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        infoDetailTv.setText(infoDetailSsb);
        svCl.addView(infoDetailTv);
        ConstraintSet infoDetailTvCs = new ConstraintSet();
        infoDetailTvCs.constrainWidth(
                infoDetailTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        infoDetailTvCs.constrainHeight(
                infoDetailTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        infoDetailTvCs.connect(
                infoDetailTv.getId(),
                ConstraintSet.TOP,
                descTv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, getContext()));
        infoDetailTvCs.connect(
                infoDetailTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(5, getContext()));
        infoDetailTvCs.applyTo(svCl);

        priceTv = new TextView(getContext());
        priceTv.setId(View.generateViewId());
        priceTv.setText(StringUtils.getPriceString(
                13,
                23,
                menuItem.getPrice()));
        svCl.addView(priceTv);
        ConstraintSet priceTvCs = new ConstraintSet();
        priceTvCs.constrainWidth(
                priceTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        priceTvCs.constrainHeight(
                priceTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.TOP,
                infoDetailTv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, getContext()));
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                DpPx.convertDp2Px(5, getContext()));
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, getContext()));
        priceTvCs.applyTo(svCl);

        PlusMinusCounter pmc = new PlusMinusCounter(getContext(), null);
        pmc.setId(View.generateViewId());
        pmc.setDelegate(this);
        svCl.addView(pmc);
        ConstraintSet pmcCs = new ConstraintSet();
        pmcCs.constrainWidth(
                pmc.getId(),
                ConstraintSet.WRAP_CONTENT);
        pmcCs.constrainHeight(
                pmc.getId(),
                ConstraintSet.WRAP_CONTENT);
        pmcCs.connect(
                pmc.getId(),
                ConstraintSet.TOP,
                infoDetailTv.getId(),
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, getContext()));
        pmcCs.connect(
                pmc.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                DpPx.convertDp2Px(5, getContext()));
        pmcCs.connect(
                pmc.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                DpPx.convertDp2Px(5, getContext()));
        pmcCs.applyTo(svCl);

        return cl;
    }

    private void setPrice(int price) {
        priceTv.setText(StringUtils.getPriceString(
                13,
                23,
                price));
    }

    @Override
    public void tapPlusBtn(int count) {
        setPrice(menuItem.getPrice() * count);
    }

    @Override
    public void tapMinusBtn(int count) {
        setPrice(menuItem.getPrice() * count);
    }

}
