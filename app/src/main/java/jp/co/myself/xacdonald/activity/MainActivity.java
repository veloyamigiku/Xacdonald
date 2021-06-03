package jp.co.myself.xacdonald.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Deque;

import jp.co.myself.xacdonald.R;
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView = findViewById(R.id.nav_view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                Deque<Integer> destinationIDStack = mvm.getDestinationIDStack();
                if (destinationIDStack.size() > 0 && destinationIDStack.peek() == destination.getId()) {
                    return;
                }
                destinationIDStack.push(destination.getId());
            }
        });
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void switchVisibleHide(boolean visible) {
        if (navView.isShown() && !visible) {
            navView.setVisibility(View.GONE);
        } else if (!navView.isShown() && visible) {
            navView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (!popBackStack()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (popBackStack()) {
                return true;
            } else {
                finish();
                return super.onOptionsItemSelected(item);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean popBackStack() {
        if (navController.getCurrentDestination().getId() != R.id.HomeFragment) {
            MainViewModel mvm = new ViewModelProvider(
                    this,
                    new MainViewModelFactory()).get(MainViewModel.class);
            Deque<Integer> destinationIDStack = mvm.getDestinationIDStack();
            destinationIDStack.pop();
            navController.navigate(destinationIDStack.peek());
            return true;
        } else {
            return false;
        }
    }
}
