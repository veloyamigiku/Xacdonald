package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;

public class MenuOrderFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_order, container, false);
    }
}
