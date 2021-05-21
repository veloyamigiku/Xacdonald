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

import java.util.ArrayList;
import java.util.List;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.model.view.menuinfodetail.MenuInfoDetailData;
import jp.co.myself.xacdonald.model.view.menuinfodetail.MenuInfoDetailHeader;
import jp.co.myself.xacdonald.model.view.menuinfodetail.MenuInfoDetailItem;

public class MenuInfoDetailFragment extends Fragment {

    private MenuItem menuItem;
    private List<MenuInfoDetailData> menuInfoDetailDataListByTab = null;
    private List<String> tabLabelList = null;

    public MenuInfoDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuItem = MenuInfoDetailFragmentArgs.fromBundle(getArguments()).getMenuItem();
            menuInfoDetailDataListByTab = fromMenuItemToMenuInfoDetailDataListByTab(menuItem);
            tabLabelList = new ArrayList<>();
            for (int i = 1; i <= menuInfoDetailDataListByTab.size(); i++) {
                tabLabelList.add("詳細情報" + String.valueOf(i));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_menu_info_detail, container, false);

        FragmentStateAdapter adapter = new FragmentStateAdapter(getActivity()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return MenuInfoDetailChildFragment.newInstance(menuInfoDetailDataListByTab.get(position));
            }

            @Override
            public int getItemCount() {
                return menuInfoDetailDataListByTab.size();
            }
        };
        ViewPager2 vp = v.findViewById(R.id.menu_info_detail_vp);
        vp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(menuInfoDetailDataListByTab.size() - 1);

        TabLayout tl = v.findViewById(R.id.menu_info_detail_tl);
        new TabLayoutMediator(tl, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabLabelList.get(position));
            }
        }).attach();

        return v;
    }

    private List<MenuInfoDetailData> fromMenuItemToMenuInfoDetailDataListByTab(MenuItem menuItem) {
        List<MenuInfoDetailData> menuInfoDetailDataListByTab = new ArrayList<>();
        menuInfoDetailDataListByTab.add(new MenuInfoDetailData(new ArrayList(){
            {
                add(new MenuInfoDetailHeader("レビュー"));
                add(new MenuInfoDetailItem("レビュー平均", String.valueOf(menuItem.getReviewRate())));
                add(new MenuInfoDetailItem("レビュー件数", String.valueOf(menuItem.getReviewCount())));
            }
        }));

        menuInfoDetailDataListByTab.add(new MenuInfoDetailData(new ArrayList(){
            {
                add(new MenuInfoDetailHeader("ポイント"));
                add(new MenuInfoDetailItem("基本ポイント数", String.valueOf(menuItem.getPointAmount())));
                add(new MenuInfoDetailItem("基本ポイント倍率", String.valueOf(menuItem.getPointTimes())));
                add(new MenuInfoDetailItem("ストアボーナス数", String.valueOf(menuItem.getPointBonusAmount())));
                add(new MenuInfoDetailItem("ストアボーナス倍率", String.valueOf(menuItem.getPointBonusTimes())));
                add(new MenuInfoDetailItem("プレミアム会員向けの基本ポイント数", String.valueOf(menuItem.getPointPremiumAmount())));
                add(new MenuInfoDetailItem("プレミアム会員向けの基本ポイント倍率", String.valueOf(menuItem.getPointPremiumTimes())));
                add(new MenuInfoDetailItem("プレミアム会員向けのストアボーナス数", String.valueOf(menuItem.getPointPremiumBonusAmount())));
                add(new MenuInfoDetailItem("プレミアム会員向けのストアボーナス倍率", String.valueOf(menuItem.getPointPremiumBonusTimes())));
            }
        }));

        menuInfoDetailDataListByTab.add(new MenuInfoDetailData(new ArrayList(){
            {
                add(new MenuInfoDetailHeader("ストア"));
                add(new MenuInfoDetailItem("ストア名", String.valueOf(menuItem.getSellerName())));
                add(new MenuInfoDetailItem("レビュー平均", String.valueOf(menuItem.getSellerReviewRate())));
                add(new MenuInfoDetailItem("レビュー件数", String.valueOf(menuItem.getSellerReviewCount())));
            }
        }));

        return menuInfoDetailDataListByTab;
    }

}
