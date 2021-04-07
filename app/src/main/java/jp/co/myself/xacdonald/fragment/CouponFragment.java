package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;

public class CouponFragment extends Fragment {

    private static final String[] COUPON_CATEGORY_LIST = {
            WebAPIConstant.CATEGORY_PS5,
            WebAPIConstant.CATEGORY_XBOX_SERIES_X_S,
            WebAPIConstant.CATEGORY_PS4,
            WebAPIConstant.CATEGORY_XBOX_ONE,
            WebAPIConstant.CATEGORY_SW,
            WebAPIConstant.CATEGORY_PS3
    };

    private static final Integer[] COUPON_CATEGORY_ID_LIST = {
            WebAPIConstant.CATEGORY_ID_PS5,
            WebAPIConstant.CATEGORY_ID_XBOX_SERIES_X_S,
            WebAPIConstant.CATEGORY_ID_PS4,
            WebAPIConstant.CATEGORY_ID_XBOX_ONE,
            WebAPIConstant.CATEGORY_ID_SW,
            WebAPIConstant.CATEGORY_ID_PS3
    };

    public CouponFragment() {
        // Required empty public constructor
    }

    public static CouponFragment newInstance() {
        CouponFragment fragment = new CouponFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConstraintLayout cl = new ConstraintLayout(getContext());

        TabLayout tl = new TabLayout(getContext());
        tl.setId(View.generateViewId());
        cl.addView(tl);
        ConstraintSet tlCs = new ConstraintSet();
        tlCs.constrainWidth(
                tl.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        tlCs.constrainHeight(
                tl.getId(),
                ConstraintSet.WRAP_CONTENT);
        tlCs.connect(
                tl.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);
        tlCs.connect(
                tl.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        tlCs.connect(
                tl.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        tlCs.applyTo(cl);

        FragmentStateAdapter adapter = new FragmentStateAdapter(getActivity()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return CouponCategoryFragment.newInstance(COUPON_CATEGORY_ID_LIST[position]);
            }

            @Override
            public int getItemCount() {
                return COUPON_CATEGORY_ID_LIST.length;
            }
        };

        ViewPager2 vp = new ViewPager2(getContext());
        vp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(COUPON_CATEGORY_LIST.length - 1);
        vp.setId(View.generateViewId());
        cl.addView(vp);
        ConstraintSet vpCs = new ConstraintSet();
        vpCs.constrainWidth(
                vp.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        vpCs.constrainHeight(
                vp.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        vpCs.connect(
                vp.getId(),
                ConstraintSet.TOP,
                tl.getId(),
                ConstraintSet.BOTTOM,
                0);
        vpCs.connect(
                vp.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        vpCs.connect(
                vp.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        vpCs.connect(
                vp.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                0);
        vpCs.applyTo(cl);

        new TabLayoutMediator(tl, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(COUPON_CATEGORY_LIST[position]);
            }
        }).attach();

        return cl;
    }
}
