package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.utils.StringUtils;
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
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                5);
        omvCs.connect(
                omv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                5);
        omvCs.connect(
                omv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                5);
        omvCs.applyTo(cl);

        return cl;
    }
}
