package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import io.reactivex.android.schedulers.AndroidSchedulers;
import jp.co.myself.xacdonald.viewmodel.MenuViewModel;
import jp.co.myself.xacdonald.viewmodel.MenuViewModelFactory;

public class MenuCategoryFragment extends Fragment {

    private static final String PARAM_MENU_CATEGORY_ID = "menu_category_id";

    private Integer menuCategoryID = null;

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