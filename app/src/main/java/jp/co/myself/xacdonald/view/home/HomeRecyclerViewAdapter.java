package jp.co.myself.xacdonald.view.home;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import jp.co.myself.xacdonald.model.view.home.HighScoreItem;
import jp.co.myself.xacdonald.model.view.home.HighScoreItemSet;
import jp.co.myself.xacdonald.model.view.home.Item;
import jp.co.myself.xacdonald.model.view.home.LowPriceItem;
import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter {

    private static final int TYPE_LOW_PRICE_ITEM = 0;

    private static final int TYPE_HIGH_SCORE_ITEM = 1;

    private List<Item> itemList;

    public HomeRecyclerViewAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_LOW_PRICE_ITEM:
                TableViewCreatorResult lowPriceItemVcResult = LowPriceItemViewCreator.create(
                        parent.getContext(),
                        parent.getWidth());
                LowPriceItemViewHolder lowPriceItemVh = new LowPriceItemViewHolder(lowPriceItemVcResult.getV(), lowPriceItemVcResult.getUiIdViewIdMap());
                return lowPriceItemVh;
            case TYPE_HIGH_SCORE_ITEM:
                TableViewCreatorResult highScoreItemSetVcResult = HighScoreItemSetViewCreator.create(
                        parent.getContext(),
                        2,
                        2,
                        parent.getWidth());
                HighScoreItemSetViewHolder highScoreItemSetVh = new HighScoreItemSetViewHolder(
                        highScoreItemSetVcResult.getV(),
                        highScoreItemSetVcResult.getUiIdViewIdMap());
                return highScoreItemSetVh;
            default:
                throw new RuntimeException("実装ミス:" + HomeRecyclerViewAdapter.class.getSimpleName() + "に関連がないアイテムがリストに存在します。");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = itemList.get(position);
        if (item instanceof LowPriceItem) {
            if (holder instanceof LowPriceItemViewHolder) {
                LowPriceItem lpi = (LowPriceItem) item;
                LowPriceItemViewHolder lpivh = (LowPriceItemViewHolder) holder;
                Glide
                        .with(lpivh.imageView)
                        .load(lpi.getImageUrl())
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(lpivh.imageView);
            }
        } else if (item instanceof HighScoreItemSet) {
            if (holder instanceof HighScoreItemSetViewHolder) {
                HighScoreItemSet highScoreItemSet = (HighScoreItemSet) item;
                List<HighScoreItem> highScoreItems = highScoreItemSet.getHighScoreItems();
                HighScoreItemSetViewHolder highScoreItemSetVh = (HighScoreItemSetViewHolder) holder;
                List<HighScoreItemView> highScoreItemViews = highScoreItemSetVh.highScoreItemViewList;
                for (int idx = 0; idx < highScoreItemViews.size(); idx++) {
                    HighScoreItemView highScoreItemView = highScoreItemViews.get(idx);
                    if (idx < highScoreItems.size()) {
                        HighScoreItem highScoreItem = highScoreItems.get(idx);
                        Glide
                                .with(highScoreItemView.imageView)
                                .load(highScoreItem.getImageUrl())
                                .diskCacheStrategy(DiskCacheStrategy.DATA)
                                .into(highScoreItemView.imageView);
                        highScoreItemView.nameTv.setText(highScoreItem.getName());
                        highScoreItemView.priceTv.setText(highScoreItem.getPrice());
                    } else {
                        highScoreItemView.imageView.setVisibility(View.INVISIBLE);
                    }
                }
            }
        } else {
            throw new RuntimeException("実装ミス:" + HomeRecyclerViewAdapter.class.getSimpleName() + "に関連がないアイテムがリストに存在します。");
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {

        Item item = itemList.get(position);
        if (item instanceof LowPriceItem) {
            return TYPE_LOW_PRICE_ITEM;
        } else if (item instanceof HighScoreItemSet) {
            return TYPE_HIGH_SCORE_ITEM;
        } else {
            throw new RuntimeException("実装ミス:" + HomeRecyclerViewAdapter.class.getSimpleName() + "に関連がないアイテムがリストに存在します。");
        }

    }
}
