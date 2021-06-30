package jp.co.myself.xacdonald.model.webapi.keyword;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class KeywordRankingRepository {

    private static KeywordRankingInterface createRepository() {

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(WebAPIConstant.YAHOO_SHOPPING_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retro.create(KeywordRankingInterface.class);

    }

    public static Observable<KeywordRankingResult> getKeywordRanking(int categoryID) {

        KeywordRankingInterface i = createRepository();
        return i.searchKeywordRanking(
                WebAPIConstant.YAHOO_API_APP_ID,
                categoryID,
                5);
    }
}
