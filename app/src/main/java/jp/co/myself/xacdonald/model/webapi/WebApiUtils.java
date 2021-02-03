package jp.co.myself.xacdonald.model.webapi;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.home.ItemSearchResult;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebApiUtils {

    private static final String YAHOO_API_BASE_URL = "https://shopping.yahooapis.jp";

    private static final String YAHOO_API_APP_ID = "dj00aiZpPWVheHgxT3VmSmp0eSZzPWNvbnN1bWVyc2VjcmV0Jng9YzU-";

    private static YahooApiInterface createYahooApi() {

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(YAHOO_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retro.create(YahooApiInterface.class);

    }

    public static Observable<ItemSearchResult> getLowPriceItemForHome() {

        YahooApiInterface yai = createYahooApi();
        return yai.itemSearchForHome(
                YAHOO_API_APP_ID,
                "new",
                50521,
                300,
                10,
                "+price");

    }

    public static Observable<ItemSearchResult> getHighScoreItemForHome() {

        YahooApiInterface yai = createYahooApi();
        return yai.itemSearchForHome(
                YAHOO_API_APP_ID,
                "new",
                50521,
                76,
                4,
                "-score");

    }

}
