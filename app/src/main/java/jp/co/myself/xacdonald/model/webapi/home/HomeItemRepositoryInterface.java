package jp.co.myself.xacdonald.model.webapi.home;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HomeItemRepositoryInterface {

    @GET("ShoppingWebService/V3/itemSearch")
    Observable<ItemSearchResult> searchHomeitem(
            @Query("appid") String appID,
            @Query("condition") String condition,
            @Query("genre_category_id") int genreCategoryId,
            @Query("image_size") int imageSize,
            @Query("results") int results,
            @Query("sort") String sort);

}
