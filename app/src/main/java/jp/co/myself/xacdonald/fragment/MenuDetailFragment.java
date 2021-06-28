package jp.co.myself.xacdonald.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.activity.MainActivity;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.utils.StringUtils;
import jp.co.myself.xacdonald.view.common.TitleHeader;

public class MenuDetailFragment extends Fragment {

    private MenuItem menuItem;

    public MenuDetailFragment() {
        // Required empty public constructor
    }

    public static MenuDetailFragment newInstance(String param1, String param2) {
        MenuDetailFragment fragment = new MenuDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuItem = MenuDetailFragmentArgs.fromBundle(getArguments()).getMenuItem();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.switchVisibleHide(true);

        ScrollView sv = new ScrollView(getContext());

        ConstraintLayout cl = new ConstraintLayout(getContext());
        sv.addView(cl);

        TitleHeader th = new TitleHeader(getContext());
        th.setId(View.generateViewId());
        SpannableStringBuilder titleSsb = new SpannableStringBuilder();
        titleSsb.append(menuItem.getName());
        titleSsb.setSpan(
                new AbsoluteSizeSpan(16, true),
                0,
                menuItem.getName().length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSsb.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                menuItem.getName().length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        th.titleTv.setText(titleSsb);
        th.setDelegate(new TitleHeader.TitleHeaderDelegate() {
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
                0);
        thCs.connect(
                th.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        thCs.connect(
                th.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        thCs.applyTo(cl);

        ImageView imageIv = new ImageView(getContext());
        imageIv.setId(View.generateViewId());
        Glide
                .with(imageIv)
                .load(menuItem.getImgUrl())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(imageIv);
        cl.addView(imageIv);
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
                th.getId(),
                ConstraintSet.BOTTOM,
                5);
        imageIvCs.connect(
                imageIv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        imageIvCs.connect(
                imageIv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                5);
        imageIvCs.applyTo(cl);

        TextView descTv = new TextView(getContext());
        descTv.setId(View.generateViewId());
        descTv.setText(menuItem.getDescription());
        cl.addView(descTv);
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
                5);
        descTvCs.connect(
                descTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        descTvCs.connect(
                descTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                5);
        descTvCs.applyTo(cl);

        TextView infoDetailTv = new TextView(getContext());
        infoDetailTv.setId(View.generateViewId());
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append("商品情報詳細");
        ssb.setSpan(
                new UnderlineSpan(),
                0,
                ssb.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        infoDetailTv.setText(ssb);
        infoDetailTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuDetailFragmentDirections.ActionMenuDetailFragmentToMenuInfoDetailFragment action =
                        MenuDetailFragmentDirections.actionMenuDetailFragmentToMenuInfoDetailFragment(menuItem);
                Navigation.findNavController(v).navigate(action);
            }
        });
        cl.addView(infoDetailTv);
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
                5);
        infoDetailTvCs.connect(
                infoDetailTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        infoDetailTvCs.applyTo(cl);

        TextView priceTv = new TextView(getContext());
        priceTv.setId(View.generateViewId());
        priceTv.setText(StringUtils.getPriceStringWithLabel(
                13,
                23,
                menuItem.getPrice(),
                "単品",
                13));
        cl.addView(priceTv);
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
                5);
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        priceTvCs.connect(
                priceTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                5);
        priceTvCs.applyTo(cl);

        Button orderBtn = new Button(getContext());
        orderBtn.setId(View.generateViewId());
        orderBtn.setText("オーダーする");
        orderBtn.setPadding(40, 0, 40, 0);
        orderBtn.setBackgroundResource(R.drawable.rounded_corners_button);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuDetailFragmentDirections.ActionMenuDetailFragmentToShopFragment directions =  MenuDetailFragmentDirections.actionMenuDetailFragmentToShopFragment(menuItem);
                Navigation.findNavController(v).navigate(directions);
            }
        });
        cl.addView(orderBtn);
        ConstraintSet orderBtnCs = new ConstraintSet();
        orderBtnCs.constrainWidth(
                orderBtn.getId(),
                ConstraintSet.WRAP_CONTENT);
        orderBtnCs.constrainHeight(
                orderBtn.getId(),
                ConstraintSet.WRAP_CONTENT);
        orderBtnCs.connect(
                orderBtn.getId(),
                ConstraintSet.TOP,
                infoDetailTv.getId(),
                ConstraintSet.BOTTOM,
                5);
        orderBtnCs.connect(
                orderBtn.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                50);
        orderBtnCs.connect(
                orderBtn.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                50);
        orderBtnCs.applyTo(cl);

        return sv;
    }

}
