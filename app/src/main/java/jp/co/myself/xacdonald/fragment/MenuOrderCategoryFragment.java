package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import jp.co.myself.xacdonald.R;

public class MenuOrderCategoryFragment extends Fragment {

    public MenuOrderCategoryFragment() {
        // Required empty public constructor
    }

    public static MenuOrderCategoryFragment newInstance() {
        MenuOrderCategoryFragment fragment = new MenuOrderCategoryFragment();
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
        return inflater.inflate(R.layout.fragment_menu_order_category, container, false);
    }
}
