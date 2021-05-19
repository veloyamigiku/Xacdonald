package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;

public class MenuDetailFragment extends Fragment {

    private MenuItem menuItem;

    public MenuDetailFragment() {
        // Required empty public constructor
    }

    public static MenuDetailFragment newInstance(String param1, String param2) {
        MenuDetailFragment fragment = new MenuDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuItem = MenuDetailFragmentArgs.fromBundle(getArguments()).getMenuItem();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_detail, container, false);
    }
}
