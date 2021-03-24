package jp.co.myself.xacdonald.model.webapi.home;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.WebApiUtils;
import jp.co.myself.xacdonald.model.webapi.YahooApiInterface;

public class HomeRepository {

    public static Observable<ItemSearchResult> getLowPriceItemForHome() {

        YahooApiInterface yai = WebApiUtils.createYahooApi();
        return yai.itemSearchForHome(
                WebApiUtils.YAHOO_API_APP_ID,
                "new",
                50521,
                300,
                10,
                "+price");

    }

    public static Observable<ItemSearchResult> getHighScoreItemForHome() {

        YahooApiInterface yai = WebApiUtils.createYahooApi();
        return yai.itemSearchForHome(
                WebApiUtils.YAHOO_API_APP_ID,
                "new",
                50521,
                300,
                4,
                "-score");

    }
}
