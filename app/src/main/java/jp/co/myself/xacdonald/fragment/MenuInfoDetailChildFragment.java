package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.model.view.menu.MenuInfoDetailData;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_info_detail_child, container, false);
    }
}