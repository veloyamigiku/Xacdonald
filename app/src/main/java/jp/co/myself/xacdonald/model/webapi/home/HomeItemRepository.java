package jp.co.myself.xacdonald.model.webapi.home;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeItemRepository {

    private static HomeItemRepositoryInterface createHomeItemRepository() {

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(WebAPIConstant.YAHOO_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retro.create(HomeItemRepositoryInterface.class);

    }

    public static Observable<ItemSearchResult> getLowPriceItem() {

        HomeItemRepositoryInterface i = createHomeItemRepository();
        return i.searchHomeitem(
                WebAPIConstant.YAHOO_API_APP_ID,
                "new",
                50521,
                300,
                10,
                "+price");

    }

    public static Observable<ItemSearchResult> getHighScoreItem() {

        HomeItemRepositoryInterface i = createHomeItemRepository();
        return i.searchHomeitem(
                WebAPIConstant.YAHOO_API_APP_ID,
                "new",
                50521,
                300,
                4,
                "-score");

    }

}
