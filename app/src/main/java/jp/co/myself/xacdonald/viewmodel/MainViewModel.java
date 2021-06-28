package jp.co.myself.xacdonald.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import java.util.ArrayDeque;
import java.util.Deque;

import jp.co.myself.xacdonald.model.view.common.DestinationBundle;

public class MainViewModel extends ViewModel {

    private Deque<DestinationBundle> destinationBundleStack = null;
    private int bvnVisibleState = View.VISIBLE;

    MainViewModel() {
        destinationBundleStack = new ArrayDeque<>();
    }

    public Deque<DestinationBundle> getDestinationBundleStack() {
        return destinationBundleStack;
    }

    public int getBvnVisibleState() {
        return bvnVisibleState;
    }

    public void setBvnVisibleState(int bvnVisibleState) {
        this.bvnVisibleState = bvnVisibleState;
    }

}
