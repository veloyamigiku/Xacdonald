package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.activity.MainActivity;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;
import jp.co.myself.xacdonald.view.common.BaseTitleHeader;
import jp.co.myself.xacdonald.view.common.TitleHeader;
import jp.co.myself.xacdonald.viewmodel.MenuOrderViewModel;
import jp.co.myself.xacdonald.viewmodel.MenuOrderViewModelFactory;

public class MenuOrderFragment extends Fragment {

    private static final String[] MENU_ORDER_CATEGORY_LIST = {
            WebAPIConstant.CATEGORY_FOOD,
            WebAPIConstant.CATEGORY_DEVICE,
            WebAPIConstant.CATEGORY_HOME_APPLIANCE,
            WebAPIConstant.CATEGORY_FURNITURE,
            WebAPIConstant.CATEGORY_BOOK,
            WebAPIConstant.CATEGORY_SPORT,
            WebAPIConstant.CATEGORY_GAME
    };

    private static final Integer[] MENU_ORDER_CATEGORY_ID_LIST = {
            WebAPIConstant.CATEGORY_ID_FOOD,
            WebAPIConstant.CATEGORY_ID_DEVICE,
            WebAPIConstant.CATEGORY_ID_HOME_APPLIANCE,
            WebAPIConstant.CATEGORY_ID_FURNITURE,
            WebAPIConstant.CATEGORY_ID_BOOK,
            WebAPIConstant.CATEGORY_ID_SPORT,
            WebAPIConstant.CATEGORY_ID_GAME
    };

    private MenuItem menuItem;

    public MenuOrderFragment() {
        // Required empty public constructor
    }

    public static MenuOrderFragment newInstance(String param1, String param2) {
        MenuOrderFragment fragment = new MenuOrderFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuItem = MenuOrderFragmentArgs.fromBundle(getArguments()).getSample();
        }
    }

    @Override
    public void onPrimaryNavigationFragmentChanged(boolean isPrimaryNavigationFragment) {
        super.onPrimaryNavigationFragmentChanged(isPrimaryNavigationFragment);
        // 画面回転等の再作成時に、メニューオーダ詳細画面への遷移を抑止する。
        MenuOrderViewModel mrvm = new ViewModelProvider(
                this,
                new MenuOrderViewModelFactory(true)).get(MenuOrderViewModel.class);
        if (mrvm.isFirstMoveWithMenuItem()) {
            mrvm.setFirstMoveWithMenuItem(false);
            MenuOrderFragmentDirections.ActionMenuOrderFragmentToMenuOrderDetailFragment directions = MenuOrderFragmentDirections.actionMenuOrderFragmentToMenuOrderDetailFragment(menuItem);
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(directions);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_menu_order, container, false);

        TitleHeader th = v.findViewById(R.id.menu_order_th);
        th.setDelegate(new BaseTitleHeader.TitleHeaderDelegate() {
            @Override
            public void tapLeftBtn() {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.popBackStackForFragment();
            }
        });

        FragmentStateAdapter adapter = new FragmentStateAdapter(getActivity()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return MenuOrderCategoryFragment.newInstance(MENU_ORDER_CATEGORY_ID_LIST[position]);
            }

            @Override
            public int getItemCount() {
                return MENU_ORDER_CATEGORY_ID_LIST.length;
            }
        };

        ViewPager2 vp = v.findViewById(R.id.menu_order_vp);
        vp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(MENU_ORDER_CATEGORY_ID_LIST.length - 1);

        TabLayout tl = v.findViewById(R.id.menu_order_tl);
        new TabLayoutMediator(tl, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(MENU_ORDER_CATEGORY_LIST[position]);
            }
        }).attach();

        return v;
    }


}
