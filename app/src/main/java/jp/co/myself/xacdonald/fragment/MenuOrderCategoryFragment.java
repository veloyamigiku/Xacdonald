package jp.co.myself.xacdonald.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.model.view.menu.KeywordRanking;
import jp.co.myself.xacdonald.model.view.menu.MenuBase;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.view.menuorder.MenuOrderRecyclerViewAdapter;
import jp.co.myself.xacdonald.viewmodel.MenuOrderViewModel;
import jp.co.myself.xacdonald.viewmodel.MenuOrderViewModelFactory;

public class MenuOrderCategoryFragment extends Fragment {

    private static final String PARAM_MENU_ORDER_CATEGORY_ID = "menu_order_category_id";

    private Integer menuCategoryID = null;

    private MenuOrderRecyclerViewAdapter morva = null;

    public MenuOrderCategoryFragment() {
        // Required empty public constructor
    }

    public static MenuOrderCategoryFragment newInstance(Integer menuCategoryID) {
        MenuOrderCategoryFragment fragment = new MenuOrderCategoryFragment();
        Bundle args = new Bundle();
        args.putInt(PARAM_MENU_ORDER_CATEGORY_ID, menuCategoryID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuCategoryID = getArguments().getInt(PARAM_MENU_ORDER_CATEGORY_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConstraintLayout cl = new ConstraintLayout(getActivity());

        RecyclerView rv = new RecyclerView(getContext());
        rv.setId(View.generateViewId());
        rv.setBackgroundColor(Color.CYAN);

        MenuOrderViewModel movm = new ViewModelProvider(
                this,
                new MenuOrderViewModelFactory(true)).get(MenuOrderViewModel.class);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                MenuBase menuBase = movm.getMenuBaseList().get(position);
                if (menuBase instanceof KeywordRanking) {
                    return 2;
                } else if (menuBase instanceof MenuItem) {
                    return 1;
                } else {
                    throw new RuntimeException("実装ミス：メニュー項目のリストに、想定外のクラスのメニュー項目が存在します。");
                }
            }
        });
        rv.setLayoutManager(manager);

        morva = new MenuOrderRecyclerViewAdapter(movm.getMenuBaseList()) {
            @Override
            public void onItemClick(MenuBase menuBase) {
                super.onItemClick(menuBase);
                MenuOrderFragmentDirections.ActionMenuOrderFragmentToMenuOrderDetailFragment directions = MenuOrderFragmentDirections.actionMenuOrderFragmentToMenuOrderDetailFragment((MenuItem) menuBase);
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(directions);
            }
        };
        rv.setAdapter(morva);
        cl.addView(rv);
        ConstraintSet rvCs = new ConstraintSet();
        rvCs.connect(
                rv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                0);
        rvCs.applyTo(cl);

        return cl;
    }

    @Override
    public void onResume() {
        super.onResume();
        MenuOrderViewModel movm = new ViewModelProvider(
                this,
                new MenuOrderViewModelFactory(true)).get(MenuOrderViewModel.class);
        if (!movm.isGotFirstMenu()) {
            movm
                    .getMenuItem(menuCategoryID)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            (res) -> {
                                Log.d(MenuOrderCategoryFragment.class.getSimpleName(), "===" + res.toString() + "===");
                                morva.notifyDataSetChanged();
                            },
                            (error) -> {
                                Log.d(MenuOrderCategoryFragment.class.getSimpleName(), error.getLocalizedMessage());
                            },
                            () -> {
                                Log.d(MenuOrderCategoryFragment.class.getSimpleName(), "===completed===");
                            });
        }
    }
}
