package jp.co.myself.xacdonald.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.viewmodel.MenuOrderViewModel;
import jp.co.myself.xacdonald.viewmodel.MenuOrderViewModelFactory;

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
        return inflater.inflate(R.layout.fragment_menu_order, container, false);
    }


}
