package jp.co.myself.xacdonald.model.webapi.shop;

import com.google.gson.annotations.SerializedName;

public class ResultInfo {

    @SerializedName("Total")
    private Integer total;

    public ResultInfo(Integer total) {
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

}
