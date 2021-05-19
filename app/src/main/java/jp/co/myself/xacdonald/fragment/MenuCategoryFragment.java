package jp.co.myself.xacdonald.fragment;

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
import jp.co.myself.xacdonald.model.view.menu.KeywordRanking;
import jp.co.myself.xacdonald.model.view.menu.MenuBase;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.view.menu.MenuRecyclerViewAdapter;
import jp.co.myself.xacdonald.viewmodel.MenuViewModel;
import jp.co.myself.xacdonald.viewmodel.MenuViewModelFactory;

public class MenuCategoryFragment extends Fragment {

    private static final String PARAM_MENU_CATEGORY_ID = "menu_category_id";

    private Integer menuCategoryID = null;

    private MenuRecyclerViewAdapter mrva = null;

    public MenuCategoryFragment() {
        // Required empty public constructor
    }

    public static MenuCategoryFragment newInstance(Integer menuCategoryID) {
        MenuCategoryFragment fragment = new MenuCategoryFragment();
        Bundle args = new Bundle();
        args.putInt(PARAM_MENU_CATEGORY_ID, menuCategoryID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuCategoryID = getArguments().getInt(PARAM_MENU_CATEGORY_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConstraintLayout cl = new ConstraintLayout(getActivity());

        MenuViewModel mvm = new ViewModelProvider(
                this,
                new MenuViewModelFactory()).get(MenuViewModel.class);
        RecyclerView rv = new RecyclerView(getContext());
        rv.setId(View.generateViewId());
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                MenuBase menuBase = mvm.getMenuBaseList().get(position);
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
        mrva = new MenuRecyclerViewAdapter(mvm.getMenuBaseList()) {
            @Override
            public void onItemClick(MenuBase menuBase) {
                MenuFragmentDirections.ActionMenuFragmentToMenuDetailFragment action = MenuFragmentDirections.actionMenuFragmentToMenuDetailFragment((MenuItem) menuBase);
                Navigation.findNavController(cl).navigate(action);
            }
        };
        rv.setAdapter(mrva);
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
        MenuViewModel mvm = new ViewModelProvider(
                this,
                new MenuViewModelFactory()).get(MenuViewModel.class);
        if (!mvm.isGotFirstMenu()) {
            mvm
                    .getMenuItem(menuCategoryID)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            (res) -> {
                                Log.d(MenuCategoryFragment.class.getSimpleName(), "===" + res.toString() + "===");
                                mvm.setMenuBaseList(res);
                                mrva.notifyDataSetChanged();
                            },
                            (error) -> {
                                Log.d(MenuCategoryFragment.class.getSimpleName(), error.getLocalizedMessage());
                            },
                            () -> {
                                Log.d(MenuCategoryFragment.class.getSimpleName(), "===completed===");
                            });
        }

    }
}