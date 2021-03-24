package jp.co.myself.xacdonald.fragment;

import android.graphics.Color;
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

public class MainFragment extends Fragment {

    private static final String[] TAB_TITLE_LIST = {
            "ホーム",
            "クーポン"
    };

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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

        if (savedInstanceState != null) {
            return null;
        }

        ConstraintLayout cl = new ConstraintLayout(getContext());

        TabLayout tl = new TabLayout(getActivity());
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
        tlCs.connect(
                tl.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                0);
        tlCs.applyTo(cl);

        FragmentStateAdapter adapter = new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return HomeFragment.newInstance();
                    case 1:
                        return CouponFragment.newInstance();
                    default:
                        throw new RuntimeException("実装上想定しない部分に到達しました。実装を確認して下さい。");
                }
            }

            @Override
            public int getItemCount() {
                return TAB_TITLE_LIST.length;
            }
        };

        ViewPager2 vp = new ViewPager2(getContext());
        vp.setId(View.generateViewId());
        vp.setAdapter(adapter);
        vp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vp.setBackgroundColor(Color.MAGENTA);
        vp.setUserInputEnabled(false);
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
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
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
                tl.getId(),
                ConstraintSet.TOP,
                0
        );
        vpCs.applyTo(cl);

        new TabLayoutMediator(tl, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(TAB_TITLE_LIST[position]);
            }
        }).attach();

        return cl;
    }
}
