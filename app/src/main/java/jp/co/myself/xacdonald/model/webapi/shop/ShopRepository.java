package jp.co.myself.xacdonald.model.webapi.shop;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIUtils;

public class ShopRepository {

    public static Observable<ShopResult> getShop(double lat, double lon) {
        ShopInterface i = WebAPIUtils.createRepository(
                ShopInterface.class,
                WebAPIConstant.YAHOO_LOCAL_API_BASE_URL);
        return i.searchShop(
                WebAPIConstant.YAHOO_API_APP_ID,
                lat,
                lon,
                "マクドナルド",
                3,
                "json");
    }

}
