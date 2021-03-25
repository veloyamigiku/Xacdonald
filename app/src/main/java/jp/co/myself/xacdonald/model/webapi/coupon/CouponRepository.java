package jp.co.myself.xacdonald.model.webapi.coupon;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CouponRepository {

    private static CouponRepositoryInterface createRepository() {

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(WebAPIConstant.YAHOO_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retro.create(CouponRepositoryInterface.class);

    }

    public static Observable<CouponSearchResult> getCoupon(int categoryID) {

        CouponRepositoryInterface i = createRepository();
        return i.searchCoupon(
                WebAPIConstant.YAHOO_API_APP_ID,
                "new",
                categoryID,
                300,
                10,
                "true",
                "+price");

    }

}
