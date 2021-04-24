package jp.co.myself.xacdonald.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainViewModel extends ViewModel {

    private Deque<Integer> destinationIDStack = null;

    MainViewModel() {
        destinationIDStack = new ArrayDeque<>();
    }

    public Deque<Integer> getDestinationIDStack() {
        return destinationIDStack;
    }
}
