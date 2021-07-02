package jp.co.myself.xacdonald.model.webapi.shop;

import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("Name")
    private String name;

    @SerializedName("Railway")
    private String railway;

    public Station(String name, String railway) {
        this.name = name;
        this.railway = railway;
    }

    public String getName() {
        return name;
    }

    public String getRailway() {
        return railway;
    }

}
