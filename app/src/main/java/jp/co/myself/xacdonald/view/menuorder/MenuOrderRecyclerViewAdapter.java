package jp.co.myself.xacdonald.view.menuorder;

import android.text.SpannableStringBuilder;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import jp.co.myself.xacdonald.model.view.menu.KeywordRanking;
import jp.co.myself.xacdonald.model.view.menu.MenuBase;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.utils.StringUtils;
import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class MenuOrderRecyclerViewAdapter extends RecyclerView.Adapter {

    private static final int MENU_ORDER_VIEW_TYPE_HEADER = 0;

    private static final int MENU_ORDER_VIEW_TYPE_ITEM = 1;

    private List<MenuBase> menuBaseList;

    public MenuOrderRecyclerViewAdapter(List<MenuBase> menuBaseList) {
        this.menuBaseList = menuBaseList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case MENU_ORDER_VIEW_TYPE_HEADER:
                TableViewCreatorResult menuOrderHeaderTvcr = MenuOrderHeaderViewCreator.create(parent.getContext());
                MenuOrderHeaderViewHolder menuOrderHeaderVh = new MenuOrderHeaderViewHolder(
                        menuOrderHeaderTvcr.getV(),
                        menuOrderHeaderTvcr.getUiIdViewIdMap());
                return menuOrderHeaderVh;
            case MENU_ORDER_VIEW_TYPE_ITEM:
                TableViewCreatorResult menuOrderItemTvcr = MenuOrderItemViewCreator.create(
                        parent.getContext(),
                        parent.getWidth());
                MenuOrderItemViewHolder menuOrderItemVh = new MenuOrderItemViewHolder(
                        menuOrderItemTvcr.getV(),
                        menuOrderItemTvcr.getUiIdViewIdMap());
                return menuOrderItemVh;
            default:
                throw new RuntimeException(MenuOrderRecyclerViewAdapter.class.getSimpleName() + ":条件分岐の実装に問題があります。");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuBase menuBase = menuBaseList.get(position);
        if (menuBase instanceof KeywordRanking) {
            KeywordRanking keywordRanking = (KeywordRanking) menuBase;
            if (holder instanceof MenuOrderHeaderViewHolder) {
                MenuOrderHeaderViewHolder menuOrderHeaderVh = (MenuOrderHeaderViewHolder) holder;
                menuOrderHeaderVh.labelTv.setText(keywordRanking.getKeyword());
            }
        } else if (menuBase instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) menuBase;
            if (holder instanceof MenuOrderItemViewHolder) {
                MenuOrderItemViewHolder menuOrderItemVh = (MenuOrderItemViewHolder) holder;
                Glide
                        .with(menuOrderItemVh.imgIv)
                        .load(menuItem.getImgUrl())
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(menuOrderItemVh.imgIv);
                menuOrderItemVh.nameTv.setText(menuItem.getName());
                SpannableStringBuilder ssb = StringUtils.getPriceString(
                        13,
                        23,
                        menuItem.getPrice());
                menuOrderItemVh.priceTv.setText(ssb);
            }
        } else {
            throw new RuntimeException("実装ミス：" + MenuOrderRecyclerViewAdapter.class.getSimpleName() + "に関連がないアイテムが存在します。");
        }
    }

    @Override
    public int getItemCount() {
        return menuBaseList.size();
    }

    @Override
    public int getItemViewType(int position) {
        MenuBase menuBase = menuBaseList.get(position);
        if (menuBase instanceof KeywordRanking) {
            return MENU_ORDER_VIEW_TYPE_HEADER;
        } else if (menuBase instanceof MenuItem) {
            return MENU_ORDER_VIEW_TYPE_ITEM;
        } else {
            throw new RuntimeException(MenuOrderRecyclerViewAdapter.class.getSimpleName() + ":条件分岐の実装に問題があります。");
        }
    }
}
