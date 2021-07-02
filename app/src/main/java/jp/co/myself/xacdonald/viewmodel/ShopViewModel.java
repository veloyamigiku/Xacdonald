package jp.co.myself.xacdonald.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import jp.co.myself.xacdonald.model.view.shop.Shop;
import jp.co.myself.xacdonald.model.webapi.shop.ShopRepository;

public class ShopViewModel extends ViewModel {

    public Observable<List<Shop>> getShop(double lat, double lon) {

        PublishSubject<List<Shop>> subject = PublishSubject.create();

        ShopRepository
                .getShop(
                        lat,
                        lon)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        (shopResult) -> {
                            subject.onNext(new ArrayList<>());
                            subject.onComplete();
                        },
                        (error) -> {
                        },
                        () -> {
                        }
                );

        return subject;

    }
}
