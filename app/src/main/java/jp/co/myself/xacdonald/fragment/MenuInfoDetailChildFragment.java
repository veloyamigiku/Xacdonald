package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import jp.co.myself.xacdonald.model.view.menuinfodetail.MenuInfoDetailData;
import jp.co.myself.xacdonald.view.menuinfodetail.MenuInfoDetailRecyclerViewAdapter;

public class MenuInfoDetailChildFragment extends Fragment {

    private static final String MENU_INFO_DETAIL_DATA = "menu_info_detail_data";

    private MenuInfoDetailData menuInfoDetailData;

    public MenuInfoDetailChildFragment() {
        // Required empty public constructor
    }

    public static MenuInfoDetailChildFragment newInstance(MenuInfoDetailData menuInfoDetailData) {
        MenuInfoDetailChildFragment fragment = new MenuInfoDetailChildFragment();
        Bundle args = new Bundle();
        args.putSerializable(MENU_INFO_DETAIL_DATA, menuInfoDetailData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuInfoDetailData = (MenuInfoDetailData) getArguments().getSerializable(MENU_INFO_DETAIL_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConstraintLayout cl = new ConstraintLayout(getContext());

        RecyclerView rv = new RecyclerView(getContext());
        rv.setId(View.generateViewId());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        MenuInfoDetailRecyclerViewAdapter adapter = new MenuInfoDetailRecyclerViewAdapter(menuInfoDetailData.getMenuInfoDetailBaseList());
        rv.setAdapter(adapter);
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
}
