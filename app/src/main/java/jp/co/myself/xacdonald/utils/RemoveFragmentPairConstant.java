package jp.co.myself.xacdonald.utils;

import java.util.ArrayList;
import java.util.List;

import jp.co.myself.xacdonald.fragment.MenuDetailFragment;
import jp.co.myself.xacdonald.fragment.MenuFragment;
import jp.co.myself.xacdonald.fragment.MenuInfoDetailFragment;

public interface RemoveFragmentPairConstant {
    List<RemoveFragmentPair> LIST = new ArrayList() {
        {
            add(new RemoveFragmentPair(MenuDetailFragment.class, MenuFragment.class));
            add(new RemoveFragmentPair(MenuInfoDetailFragment.class, MenuDetailFragment.class));
        }
    };
}
