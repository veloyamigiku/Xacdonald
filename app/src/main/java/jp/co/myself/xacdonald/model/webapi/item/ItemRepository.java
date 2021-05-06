package jp.co.myself.xacdonald.model.webapi.item;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;
import jp.co.myself.xacdonald.model.webapi.keyword.RankingData;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemRepository {

    private static ItemInterface createRepository() {

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(WebAPIConstant.YAHOO_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retro.create(ItemInterface.class);

    }

    public static Observable<ItemResult> searchItem(int categoryID) {

        ItemInterface i = createRepository();
        return i.searchItem(
                WebAPIConstant.YAHOO_API_APP_ID,
                "new",
                categoryID,
                300,
                10,
                "+price");

    }

    public static Observable<ItemWithRankingDataResult> searchItem(int categoryID, RankingData rankingData) {

        ItemInterface i = createRepository();
        PublishSubject subject = PublishSubject.create();
        i
                .searchItem(
                        WebAPIConstant.YAHOO_API_APP_ID,
                        "new",
                        categoryID,
                        300,
                        10,
                        "+price",
                        rankingData.getQuery())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        (itemResult) -> {
                            ItemWithRankingDataResult iwrdr = new ItemWithRankingDataResult(
                                    itemResult.getHits(),
                                    rankingData);
                            subject.onNext(iwrdr);
                            subject.onComplete();
                        },
                        (error) -> {
                            subject.onError(error);
                        }
                );
        return subject;

    }
}
