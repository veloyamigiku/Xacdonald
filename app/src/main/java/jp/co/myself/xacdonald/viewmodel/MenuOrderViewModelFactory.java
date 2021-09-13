package jp.co.myself.xacdonald.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MenuOrderViewModelFactory implements ViewModelProvider.Factory {

    private Boolean isFirstMoveWithMenuItem;

    public MenuOrderViewModelFactory(boolean isFirstMoveWithMenuItem) {
        this.isFirstMoveWithMenuItem = isFirstMoveWithMenuItem;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MenuOrderViewModel(isFirstMoveWithMenuItem);
    }

    public void setFirstMoveWithMenuItem(Boolean firstMoveWithMenuItem) {
        isFirstMoveWithMenuItem = firstMoveWithMenuItem;
    }

}
