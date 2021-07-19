package jp.co.myself.xacdonald.viewmodel;

import android.location.Location;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import jp.co.myself.xacdonald.model.view.shop.Shop;
import jp.co.myself.xacdonald.model.webapi.shop.Feature;
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
                            List<Shop> shopList = new ArrayList<>();
                            for (Feature f : shopResult.getFeature()) {
                                String name = f.getName();
                                String address = f.getProperty().getAddress();
                                String tel = f.getProperty().getTel1();
                                String station = "";
                                String railway = "";
                                if (f.getProperty().getStation().size() > 0) {
                                    station = f.getProperty().getStation().get(0).getName();
                                    railway = f.getProperty().getStation().get(0).getRailway();
                                }
                                Double shopLat = null;
                                Double shopLon = null;
                                String[] coordinates = f.getGeometry().getCoordinates().split(",");
                                if (coordinates.length >= 2) {
                                    shopLat = Double.parseDouble(coordinates[1]);
                                    shopLon = Double.parseDouble(coordinates[0]);
                                }

                                float[] resDistanceBetween = new float[3];
                                Location.distanceBetween(lat, lon, shopLat, shopLon, resDistanceBetween);
                                shopList.add(new Shop(
                                        name,
                                        address,
                                        tel,
                                        station,
                                        railway,
                                        shopLat,
                                        shopLon,
                                        resDistanceBetween[0]));
                            }
                            subject.onNext(shopList);
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
