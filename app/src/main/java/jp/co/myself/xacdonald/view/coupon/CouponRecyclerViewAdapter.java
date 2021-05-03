package jp.co.myself.xacdonald.view.coupon;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import jp.co.myself.xacdonald.model.view.coupon.CouponBase;
import jp.co.myself.xacdonald.model.view.coupon.CouponData;
import jp.co.myself.xacdonald.view.common.TableViewCreatorResult;

public class CouponRecyclerViewAdapter extends RecyclerView.Adapter {

    private static final int ITEM_VIEW_TYPE_COUPON = 0;

    private List<CouponBase> couponList;

    public CouponRecyclerViewAdapter(List<CouponBase> couponList) {
        this.couponList = couponList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_VIEW_TYPE_COUPON:
                TableViewCreatorResult couponVcResult = CouponViewCreator.create(parent.getContext(), parent.getWidth());
                CouponViewHolder couponVh = new CouponViewHolder(couponVcResult.getV(), couponVcResult.getUiIdViewIdMap());
                couponVh.detailTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onCouponDetailClicked(couponVh.getAdapterPosition());
                    }
                });
                return couponVh;
            default:
                throw new RuntimeException(CouponRecyclerViewAdapter.class.getSimpleName() + ":条件分岐の実装に問題があります。");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CouponBase couponBase = couponList.get(position);
        if (couponBase instanceof CouponData) {
            if (holder instanceof CouponViewHolder) {
                CouponData coupon = (CouponData) couponBase;
                CouponViewHolder cvh = (CouponViewHolder) holder;
                Glide
                        .with(cvh.itemView)
                        .load(coupon.getImgUrl())
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(cvh.imgIv);
                cvh.nameTv.setText(coupon.getName());
                cvh.priceTv.setText(String.format("%,d", coupon.getPrice()));
            }
        } else {
            throw new RuntimeException("実装ミス:" + CouponRecyclerViewAdapter.class.getSimpleName() + "に関連がないアイテムが存在します。");
        }
    }

    @Override
    public int getItemCount() {
        return couponList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (couponList.get(position) instanceof CouponData) {
            return ITEM_VIEW_TYPE_COUPON;
        } else {
            throw new RuntimeException(CouponRecyclerViewAdapter.class.getSimpleName() + ":条件分岐の実装に問題があります。");
        }
    }

    protected void onCouponDetailClicked(int couponIndex) {}

}
