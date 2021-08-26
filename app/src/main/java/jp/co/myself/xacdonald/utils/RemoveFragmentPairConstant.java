package jp.co.myself.xacdonald.utils;

import java.util.ArrayList;
import java.util.List;

import jp.co.myself.xacdonald.fragment.MenuDetailFragment;
import jp.co.myself.xacdonald.fragment.MenuFragment;
import jp.co.myself.xacdonald.fragment.MenuInfoDetailFragment;
import jp.co.myself.xacdonald.fragment.MenuOrderFragment;
import jp.co.myself.xacdonald.fragment.ShopFragment;

public interface RemoveFragmentPairConstant {
    List<RemoveFragmentPair> LIST = new ArrayList() {
        {
            add(new RemoveFragmentPair(MenuDetailFragment.class, MenuFragment.class));
            add(new RemoveFragmentPair(MenuInfoDetailFragment.class, MenuDetailFragment.class));
            add(new RemoveFragmentPair(ShopFragment.class, MenuDetailFragment.class));
            add(new RemoveFragmentPair(MenuOrderFragment.class, ShopFragment.class));
        }
    };
}
