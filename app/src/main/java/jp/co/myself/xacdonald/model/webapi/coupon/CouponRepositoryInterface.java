package jp.co.myself.xacdonald.model.webapi.coupon;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CouponRepositoryInterface {

    @GET("ShoppingWebService/V3/itemSearch")
    Observable<CouponSearchResult> searchCoupon(
            @Query("appid") String appID,
            @Query("condition") String condition,
            @Query("genre_category_id") int genreCategoryId,
            @Query("image_size") int imageSize,
            @Query("results") int results,
            @Query("is_discount") String isDiscount,
            @Query("sort") String sort);

}
