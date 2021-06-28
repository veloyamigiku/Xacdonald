package jp.co.myself.xacdonald.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Deque;

import jp.co.myself.xacdonald.R;
import jp.co.myself.xacdonald.model.view.common.DestinationBundle;
import jp.co.myself.xacdonald.viewmodel.MainViewModel;
import jp.co.myself.xacdonald.viewmodel.MainViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navView = null;
    private NavController navController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel mvm = new ViewModelProvider(
                this,
                new MainViewModelFactory()).get(MainViewModel.class);

        navView = findViewById(R.id.nav_view);
        navView.setVisibility(mvm.getBvnVisibleState());
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                Deque<DestinationBundle> destinationBundleStack = mvm.getDestinationBundleStack();
                if (destinationBundleStack.size() > 0 && destinationBundleStack.peek().getId() == destination.getId()) {
                    return;
                }
                destinationBundleStack.push(new DestinationBundle(destination.getId(), arguments));
            }
        });
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void switchVisibleHide(boolean hide) {
        MainViewModel mvm = new ViewModelProvider(
                this,
                new MainViewModelFactory()).get(MainViewModel.class);
        if (navView.isShown() && hide) {
            navView.setVisibility(View.GONE);
            mvm.setBvnVisibleState(View.GONE);
        } else if (!navView.isShown() && !hide) {
            navView.setVisibility(View.VISIBLE);
            mvm.setBvnVisibleState(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (!popBackStack()) {
            super.onBackPressed();
        }
    }

    public void popBackStackForFragment() {
        popBackStack();
    }

    private boolean popBackStack() {
        if (navController.getCurrentDestination().getId() != R.id.HomeFragment) {
            MainViewModel mvm = new ViewModelProvider(
                    this,
                    new MainViewModelFactory()).get(MainViewModel.class);
            Deque<DestinationBundle> destinationBundleStack = mvm.getDestinationBundleStack();
            destinationBundleStack.pop();
            DestinationBundle db = destinationBundleStack.peek();
            navController.navigate(db.getId(), db.getBundle());
            return true;
        } else {
            return false;
        }
    }


}
