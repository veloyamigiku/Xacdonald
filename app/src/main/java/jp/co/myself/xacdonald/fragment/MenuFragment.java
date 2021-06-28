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
import jp.co.myself.xacdonald.activity.MainActivity;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;

public class MenuFragment extends Fragment {

    private static final String[] MENU_CATEGORY_LIST = {
            WebAPIConstant.CATEGORY_FOOD,
            WebAPIConstant.CATEGORY_DEVICE,
            WebAPIConstant.CATEGORY_HOME_APPLIANCE,
            WebAPIConstant.CATEGORY_FURNITURE,
            WebAPIConstant.CATEGORY_BOOK,
            WebAPIConstant.CATEGORY_SPORT,
            WebAPIConstant.CATEGORY_GAME
    };

    private static final Integer[] MENU_CATEGORY_ID_LIST = {
            WebAPIConstant.CATEGORY_ID_FOOD,
            WebAPIConstant.CATEGORY_ID_DEVICE,
            WebAPIConstant.CATEGORY_ID_HOME_APPLIANCE,
            WebAPIConstant.CATEGORY_ID_FURNITURE,
            WebAPIConstant.CATEGORY_ID_BOOK,
            WebAPIConstant.CATEGORY_ID_SPORT,
            WebAPIConstant.CATEGORY_ID_GAME,
    };

    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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

        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        FragmentStateAdapter adapter = new FragmentStateAdapter(getActivity()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return MenuCategoryFragment.newInstance(MENU_CATEGORY_ID_LIST[position]);
            }

            @Override
            public int getItemCount() {
                return MENU_CATEGORY_ID_LIST.length;
            }
        };

        ViewPager2 vp = v.findViewById(R.id.menu_vp);
        vp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(MENU_CATEGORY_ID_LIST.length - 1);

        TabLayout tl = v.findViewById(R.id.menu_tl);
        new TabLayoutMediator(tl, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(MENU_CATEGORY_LIST[position]);
            }
        }).attach();

        return v;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.switchVisibleHide(false);
        }
    }

}
