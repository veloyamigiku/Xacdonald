package jp.co.myself.xacdonald.model.webapi.shop;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopResult {

    @SerializedName("ResultInfo")
    private ResultInfo resultInfo;

    @SerializedName("Feature")
    private List<Feature> feature;

    public ShopResult(
            ResultInfo resultInfo,
            List<Feature> feature) {
        this.resultInfo = resultInfo;
        this.feature = feature;
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public List<Feature> getFeature() {
        return feature;
    }

}
