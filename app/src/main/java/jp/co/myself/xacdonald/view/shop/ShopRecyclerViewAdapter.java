package jp.co.myself.xacdonald.view.shop;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
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

        SpannableStringBuilder statusSsb = new SpannableStringBuilder();
        statusSsb.append("営業中");
        statusSsb.setSpan(
                new ForegroundColorSpan(Color.RED),
                0,
                statusSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        statusSsb.setSpan(
                new AbsoluteSizeSpan(10, true),
                0,
                statusSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sivh.statusTv.setText(statusSsb);

        SpannableStringBuilder distanceSsb = new SpannableStringBuilder();
        distanceSsb.append(shop.getDist().intValue() + "m");
        distanceSsb.setSpan(
                new ForegroundColorSpan(Color.GRAY),
                0,
                distanceSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        distanceSsb.setSpan(
                new AbsoluteSizeSpan(10, true),
                0,
                distanceSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sivh.distanceTv.setText(distanceSsb);

        SpannableStringBuilder nameSsb = new SpannableStringBuilder();
        nameSsb.append(shop.getName());
        nameSsb.setSpan(
                new AbsoluteSizeSpan(12, true),
                0,
                nameSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        nameSsb.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                nameSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sivh.nameTv.setText(nameSsb);

        SpannableStringBuilder addressSsb = new SpannableStringBuilder();
        addressSsb.append(shop.getAddress());
        addressSsb.setSpan(
                new AbsoluteSizeSpan(10, true),
                0,
                addressSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addressSsb.setSpan(
                new ForegroundColorSpan(Color.GRAY),
                0,
                addressSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sivh.addressTv.setText(addressSsb);

        SpannableStringBuilder stationSsb = new SpannableStringBuilder();
        stationSsb.append(shop.getStation());
        stationSsb.setSpan(
                new AbsoluteSizeSpan(10, true),
                0,
                stationSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stationSsb.setSpan(
                new ForegroundColorSpan(Color.GRAY),
                0,
                stationSsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sivh.stationTv.setText(stationSsb);

        SpannableStringBuilder railwaySsb = new SpannableStringBuilder();
        railwaySsb.append(shop.getRailway());
        railwaySsb.setSpan(
                new AbsoluteSizeSpan(10, true),
                0,
                railwaySsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        railwaySsb.setSpan(
                new ForegroundColorSpan(Color.GRAY),
                0,
                railwaySsb.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sivh.railwayTv.setText(railwaySsb);

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
