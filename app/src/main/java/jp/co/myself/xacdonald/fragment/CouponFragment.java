package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import jp.co.myself.xacdonald.R;
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

        View v = inflater.inflate(R.layout.fragment_coupon, container, false);

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

        ViewPager2 vp = v.findViewById(R.id.coupon_vp);
        vp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(COUPON_CATEGORY_LIST.length - 1);

        TabLayout tl = v.findViewById(R.id.coupon_tl);
        new TabLayoutMediator(tl, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(COUPON_CATEGORY_LIST[position]);
            }
        }).attach();

        return v;
    }

}
