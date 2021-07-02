package jp.co.myself.xacdonald.model.webapi.shop;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Property {

    @SerializedName("Address")
    private String address;

    @SerializedName("Tel1")
    private String tel1;

    @SerializedName("Station")
    private List<Station> station;

    public Property(
            String address,
            String tel1,
            List<Station> station) {
        this.address = address;
        this.tel1 = tel1;
        this.station = station;
    }

    public String getAddress() {
        return address;
    }

    public String getTel1() {
        return tel1;
    }

    public List<Station> getStation() {
        return station;
    }

}
