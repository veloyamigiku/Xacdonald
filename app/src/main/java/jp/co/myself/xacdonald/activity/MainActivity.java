package jp.co.myself.xacdonald.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import jp.co.myself.xacdonald.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static final String MAIN_FRAGMENT_ID = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout fl = new FrameLayout(this);
        fl.setId(View.generateViewId());
        setContentView(fl);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(MAIN_FRAGMENT_ID);
        FragmentTransaction ft = fm.beginTransaction();
        if (fragment != null) {
            ft.remove(fragment);
        }
        ft.replace(
                fl.getId(),
                MainFragment.newInstance(),
                MAIN_FRAGMENT_ID);
        ft.commit();
    }
}
