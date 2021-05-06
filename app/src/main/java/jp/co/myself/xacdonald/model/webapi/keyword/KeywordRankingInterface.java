package jp.co.myself.xacdonald.model.webapi.keyword;

import io.reactivex.Observable;
import jp.co.myself.xacdonald.model.webapi.common.WebAPIConstant;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KeywordRankingInterface {

    @GET(WebAPIConstant.KEYWORD_RANKING_PATH)
    Observable<KeywordRankingResult> searchKeywordRanking(
            @Query("appid") String appID,
            @Query("category_id") int categoryID,
            @Query("hits") int hits);

}
