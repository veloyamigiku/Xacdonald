package jp.co.myself.xacdonald;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;

import java.util.ArrayDeque;
import java.util.Deque;

@Navigator.Name("custom_fragment")
public class CustomNavigator extends FragmentNavigator {

    private FragmentManager manager = null;
    private Context context = null;
    private Integer containerId = null;
    private Deque<Integer> destinationIDStack = null;

    public CustomNavigator(@NonNull Context context, @NonNull FragmentManager manager, int containerId) {
        super(context, manager, containerId);
        this.manager = manager;
        this.context = context;
        this.containerId = containerId;
        this.destinationIDStack = new ArrayDeque<>();
    }

    @Nullable
    @Override
    public NavDestination navigate(@NonNull Destination destination, @Nullable Bundle args, @Nullable NavOptions navOptions, @Nullable Navigator.Extras navigatorExtras) {
        if (manager.isStateSaved()) {
            return null;
        }

        String className = destination.getClassName();
        if (className.charAt(0) == '.') {
            className = context.getPackageName() + className;
        }

        String tag = String.valueOf(destination.getId());
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment currentFragment = manager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
            //transaction.detach(currentFragment);
        }

        Fragment fragment = manager.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = manager.getFragmentFactory().instantiate(
                    context.getClassLoader(),
                    className);
            transaction.add(
                    containerId,
                    fragment,
                    tag);
        }
        fragment.setArguments(args);

        transaction.show(fragment);
        //transaction.attach(fragment);
        transaction.setPrimaryNavigationFragment(fragment);
        transaction.commit();

        destinationIDStack.push(destination.getId());

        return destination;
    }

}
