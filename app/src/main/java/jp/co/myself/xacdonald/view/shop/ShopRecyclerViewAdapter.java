package jp.co.myself.xacdonald.view.shop;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jp.co.myself.xacdonald.model.view.shop.Shop;
import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class ShopRecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Shop> shopList;

    public ShopRecyclerViewAdapter() {
        shopList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TableViewCreatorResult shopItemViewResult = ShopItemViewCreator.create(parent.getContext());
        ShopItemViewHolder shopItemVh = new ShopItemViewHolder(
                shopItemViewResult.getV(),
                shopItemViewResult.getUiIdViewIdMap());
        return shopItemVh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Shop shop = shopList.get(position);
        ShopItemViewHolder sivh = (ShopItemViewHolder) holder;
        sivh.tv.setText(shop.getName());
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList.clear();
        this.shopList.addAll(shopList);
    }

}
