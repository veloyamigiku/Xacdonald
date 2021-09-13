package jp.co.myself.xacdonald.viewmodel;

import androidx.lifecycle.ViewModel;

public class MenuOrderViewModel extends ViewModel {

    private boolean isFirstMoveWithMenuItem;

    MenuOrderViewModel(boolean isFirstMoveWithMenuItem) {
        this.isFirstMoveWithMenuItem = isFirstMoveWithMenuItem;
    }

    public boolean isFirstMoveWithMenuItem() {
        return isFirstMoveWithMenuItem;
    }

    public void setFirstMoveWithMenuItem(boolean isFirstMoveWithMenuItem) {
        this.isFirstMoveWithMenuItem = isFirstMoveWithMenuItem;
    }
}
