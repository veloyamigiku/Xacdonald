package jp.co.myself.xacdonald.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import jp.co.myself.xacdonald.model.view.coupon.CouponBase;
import jp.co.myself.xacdonald.model.view.coupon.CouponData;
import jp.co.myself.xacdonald.model.webapi.coupon.Coupon;
import jp.co.myself.xacdonald.model.webapi.coupon.CouponRepository;

public class CouponViewModel extends ViewModel {

    private final List<CouponBase> couponList;
    private final PublishSubject<List<CouponBase>> couponSubject;
    private boolean gotFirstCoupon;

    public CouponViewModel() {
        this.couponList = new ArrayList<>();
        this.couponSubject = PublishSubject.create();
        this.gotFirstCoupon = false;
    }

    public List<CouponBase> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<CouponBase> couponList) {
        this.couponList.clear();
        this.couponList.addAll(couponList);
    }

    public Observable<List<CouponBase>> getCoupon(int categoryID) {
        CouponRepository
                .getCoupon(categoryID)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        (res) -> {
                            Log.d(CouponViewModel.class.getSimpleName(), "ok");
                            List<CouponBase> couponList = new ArrayList<>();
                            for (Coupon coupon : res.getHits()) {
                                couponList.add(
                                        new CouponData(
                                                coupon.getName(),
                                                coupon.getDescription(),
                                                Integer.parseInt(coupon.getPrice()),
                                                coupon.getExImage().getUrl()));
                            }
                            couponSubject.onNext(couponList);
                            couponSubject.onComplete();
                            gotFirstCoupon = true;
                            },
                        (err) -> {
                            Log.d(CouponViewModel.class.getSimpleName(), "err");
                            couponSubject.onError(err);
                        },
                        () -> {
                            Log.d(CouponViewModel.class.getSimpleName(), "complete");
                        });
        return couponSubject;
    }

    public boolean isGotFirstCoupon() {
        return gotFirstCoupon;
    }
}
