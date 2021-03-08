package jp.co.myself.xacdonald.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import jp.co.myself.xacdonald.model.view.home.HighScoreItem;
import jp.co.myself.xacdonald.model.view.home.HighScoreItemSet;
import jp.co.myself.xacdonald.model.view.home.Item;
import jp.co.myself.xacdonald.model.view.home.LowPriceItem;
import jp.co.myself.xacdonald.model.webapi.WebApiUtils;
import jp.co.myself.xacdonald.model.webapi.home.Hit;
import jp.co.myself.xacdonald.model.webapi.home.ItemSearchResult;

public class HomeViewModel extends ViewModel {

    private CompositeDisposable cd = null;
    private PublishSubject<List<Item>> subject = null;
    private List<Item> items = null;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    HomeViewModel() {
        cd = new CompositeDisposable();
        subject = PublishSubject.create();
        items = new ArrayList<>();
    }

    public Observable<List<Item>> searchItemForHome() {

        Observable<ItemSearchResult> lowPriceItemSearchResultObs = WebApiUtils.getLowPriceItemForHome();
        Observable<ItemSearchResult> highScoreItemSearchResultObs = WebApiUtils.getHighScoreItemForHome();
        Observable<List<Item>> result =
                Observable.zip(lowPriceItemSearchResultObs.subscribeOn(Schedulers.io()), highScoreItemSearchResultObs.subscribeOn(Schedulers.io()), new BiFunction<ItemSearchResult, ItemSearchResult, List<Item>>() {
                    @NonNull
                    @Override
                    public List<Item> apply(@NonNull ItemSearchResult lowPriceItemSearchResult, @NonNull ItemSearchResult highScoreItemSearchResult) throws Exception {
                        List<Item> items = new ArrayList<>();
                        for (Hit hit : lowPriceItemSearchResult.getHits()) {
                            LowPriceItem lpi = new LowPriceItem(hit.getExImage().getUrl());
                            items.add(lpi);
                        }
                        List<HighScoreItem> highScoreItems = new ArrayList<>();
                        for (Hit hit : highScoreItemSearchResult.getHits()) {
                            HighScoreItem hsi = new HighScoreItem(
                                    hit.getName(),
                                    hit.getPrice(),
                                    hit.getExImage().getUrl());
                            highScoreItems.add(hsi);
                        }
                        HighScoreItemSet hsis = new HighScoreItemSet(highScoreItems);
                        items.add(1, hsis);
                        return items;
                    }
                });
        Disposable d = result.subscribe(
                (res) -> {
                    subject.onNext(res);
                },
                (error) -> {
                    subject.onError(error);
                });
        cd.add(d);

        return subject;
    }

}
