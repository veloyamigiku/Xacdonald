package jp.co.myself.xacdonald.model.webapi.shop;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopInterface {

    @GET(WebAPIConstant.LOCAL_SEARCH_PATH)
    Observable<ShopResult> searchShop(
            @Query("appid") String appID,
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("query") String query,
            @Query("dist") double dist,
            @Query("output") String output,
            @Query("sort") String sort);
}
