package jp.co.myself.xacdonald.model.webapi;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.home.ItemSearchResult;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YahooApiInterface {

    @GET("ShoppingWebService/V3/itemSearch")
    Observable<ItemSearchResult> itemSearchForHome(
            @Query("appid") String appID,
            @Query("condition") String condition,
            @Query("genre_category_id") int genreCategoryId,
            @Query("image_size") int imageSize,
            @Query("result") int results,
            @Query("sort") String sort);

}
