package jp.co.myself.xacdonald.model.webapi.shop;

import com.google.gson.annotations.SerializedName;

public class Geometry {

    @SerializedName("Coordinates")
    private String coordinates;

    public Geometry(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }

}
