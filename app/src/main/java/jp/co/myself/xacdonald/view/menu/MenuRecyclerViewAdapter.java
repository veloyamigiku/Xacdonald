package jp.co.myself.xacdonald.view.menu;

import android.text.SpannableStringBuilder;
import android.view.View;
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

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter {

    private static final int MENU_VIEW_TYPE_HEADER = 0;

    private static final int MENU_VIEW_TYPE_ITEM = 1;

    private List<MenuBase> menuBaseList;

    public MenuRecyclerViewAdapter(List<MenuBase> menuBaseList) {
        this.menuBaseList = menuBaseList;
    }

    public void onItemClick(MenuBase menuBase) {}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case MENU_VIEW_TYPE_HEADER:
                TableViewCreatorResult menuHeaderVc = MenuHeaderViewCreator.create(
                        parent.getContext(),
                        parent.getWidth());
                MenuHeaderViewHolder menuHeaderVh = new MenuHeaderViewHolder(
                        menuHeaderVc.getV(),
                        menuHeaderVc.getUiIdViewIdMap());
                return menuHeaderVh;
            case MENU_VIEW_TYPE_ITEM:
                TableViewCreatorResult menuItemVc = MenuItemViewCreator.create(
                        parent.getContext(),
                        parent.getWidth());
                MenuItemViewHolder menuItemVh = new MenuItemViewHolder(
                        menuItemVc.getV(),
                        menuItemVc.getUiIdViewIdMap());
                menuItemVh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClick(menuBaseList.get(menuItemVh.getAdapterPosition()));
                    }
                });
                return menuItemVh;
            default:
                throw new RuntimeException(MenuRecyclerViewAdapter.class.getSimpleName() + ":条件分岐の実装に問題があります。");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuBase menuBase = menuBaseList.get(position);
        if (menuBase instanceof KeywordRanking) {
            KeywordRanking keywordRanking = (KeywordRanking) menuBase;
            if (holder instanceof MenuHeaderViewHolder) {
                MenuHeaderViewHolder menuHeaderVh = (MenuHeaderViewHolder) holder;
                menuHeaderVh.labelTv.setText(keywordRanking.getKeyword());
            }
        } else if (menuBase instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) menuBase;
            if (holder instanceof  MenuItemViewHolder) {
                MenuItemViewHolder menuItemVh = (MenuItemViewHolder) holder;
                Glide
                        .with(menuItemVh.imgIv)
                        .load(menuItem.getImgUrl())
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(menuItemVh.imgIv);
                menuItemVh.nameTv.setText(menuItem.getName());
                SpannableStringBuilder ssb = StringUtils.getPriceString(
                        13,
                        23,
                        menuItem.getPrice());
                menuItemVh.priceTv.setText(ssb);
            }
        } else {
            throw new RuntimeException("実装ミス:" + MenuRecyclerViewAdapter.class.getSimpleName() + "に関連がないアイテムが存在します。");
        }
    }

    @Override
    public int getItemCount() {
        return menuBaseList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (menuBaseList.get(position) instanceof KeywordRanking) {
            return MENU_VIEW_TYPE_HEADER;
        } else if (menuBaseList.get(position) instanceof MenuItem) {
            return MENU_VIEW_TYPE_ITEM;
        } else {
            throw new RuntimeException(MenuRecyclerViewAdapter.class.getSimpleName() + ":条件分岐の実装に問題があります。");
        }
    }

}
