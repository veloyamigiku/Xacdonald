package jp.co.myself.xacdonald.model.webapi.item;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItemInterface {

    @GET(WebAPIConstant.ITEM_SEARCH_PATH)
    Observable<ItemResult> searchItem(
            @Query("appid") String appID,
            @Query("condition") String condition,
            @Query("genre_category_id") int genreCategoryId,
            @Query("image_size") int imageSize,
            @Query("results") int results,
            @Query("sort") String sort,
            @Query("query") String query);

    @GET(WebAPIConstant.ITEM_SEARCH_PATH)
    Observable<ItemResult> searchItem(
            @Query("appid") String appID,
            @Query("condition") String condition,
            @Query("genre_category_id") int genreCategoryId,
            @Query("image_size") int imageSize,
            @Query("results") int results,
            @Query("sort") String sort);

}
