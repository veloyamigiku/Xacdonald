package jp.co.myself.xacdonald.view.menuinfodetail;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jp.co.myself.xacdonald.fragment.MenuInfoDetailFragment;
import jp.co.myself.xacdonald.model.view.menuinfodetail.MenuInfoDetailBase;
import jp.co.myself.xacdonald.model.view.menuinfodetail.MenuInfoDetailHeader;
import jp.co.myself.xacdonald.model.view.menuinfodetail.MenuInfoDetailItem;
import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class MenuInfoDetailRecyclerViewAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_MENU_INFO_DETAIL_ITEM = 0;
    private static final int VIEW_TYPE_MENU_INFO_DETAIL_HEADER = 1;

    private List<MenuInfoDetailBase> menuInfoDetailBaseList;

    public MenuInfoDetailRecyclerViewAdapter(
            List<MenuInfoDetailBase> menuInfoDetailBaseList) {
        this.menuInfoDetailBaseList = menuInfoDetailBaseList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_MENU_INFO_DETAIL_HEADER:
                TableViewCreatorResult menuInfoDetailHeaderVc = MenuInfoDetailHeaderViewCreator.create(
                        parent.getContext());
                MenuInfoDetailHeaderViewHolder menuInfoDetailHeaderVh = new MenuInfoDetailHeaderViewHolder(
                        menuInfoDetailHeaderVc.getV(),
                        menuInfoDetailHeaderVc.getUiIdViewIdMap());
                return menuInfoDetailHeaderVh;
            case VIEW_TYPE_MENU_INFO_DETAIL_ITEM:
                TableViewCreatorResult menuInfoDetailItemVc = MenuInfoDetailItemViewCreator.create(
                        parent.getContext());
                MenuInfoDetailItemViewHolder menuInfoDetailItemVh = new MenuInfoDetailItemViewHolder(
                        menuInfoDetailItemVc.getV(),
                        menuInfoDetailItemVc.getUiIdViewIdMap());
                return menuInfoDetailItemVh;
            default:
                throw new RuntimeException(MenuInfoDetailRecyclerViewAdapter.class.getSimpleName() +
                        ":本例外は発生を想定していないため実装を確認してください。");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuInfoDetailBase midb = menuInfoDetailBaseList.get(position);
        if (holder instanceof MenuInfoDetailHeaderViewHolder && midb instanceof MenuInfoDetailHeader) {
            MenuInfoDetailHeaderViewHolder menuInfoDetailHeaderVh = (MenuInfoDetailHeaderViewHolder) holder;
            MenuInfoDetailHeader midh = (MenuInfoDetailHeader) midb;
            menuInfoDetailHeaderVh.labelTv.setText(((MenuInfoDetailHeader) midb).getLabel());
        } else if (holder instanceof MenuInfoDetailItemViewHolder && midb instanceof MenuInfoDetailItem) {
            MenuInfoDetailItemViewHolder menuInfoDetailItemVh = (MenuInfoDetailItemViewHolder) holder;
            MenuInfoDetailItem midi = (MenuInfoDetailItem) midb;
            menuInfoDetailItemVh.labelTv.setText(((MenuInfoDetailItem) midb).getLabel());
            menuInfoDetailItemVh.valueTv.setText(midi.getValue());
        }
    }

    @Override
    public int getItemCount() {
        return menuInfoDetailBaseList.size();
    }

    @Override
    public int getItemViewType(int position) {
        MenuInfoDetailBase midb = menuInfoDetailBaseList.get(position);
        if (midb instanceof MenuInfoDetailItem) {
            return VIEW_TYPE_MENU_INFO_DETAIL_ITEM;
        } else if (midb instanceof MenuInfoDetailHeader) {
            return VIEW_TYPE_MENU_INFO_DETAIL_HEADER;
        } else {
            throw new RuntimeException(MenuInfoDetailFragment.class.getSimpleName() +
                    ":データリストに想定外のクラスインスタンスが存在します。");
        }
    }
}
