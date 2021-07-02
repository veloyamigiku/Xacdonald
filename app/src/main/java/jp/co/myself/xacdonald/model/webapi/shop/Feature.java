package jp.co.myself.xacdonald.model.webapi.shop;

import com.google.gson.annotations.SerializedName;

public class Feature {

    @SerializedName("Name")
    private String name;

    @SerializedName("Property")
    private Property property;

    @SerializedName("Geometry")
    private Geometry geometry;

    public Feature(String name, Property property, Geometry geometry) {
        this.name = name;
        this.property = property;
        this.geometry = geometry;
    }

    public String getName() {
        return name;
    }

    public Property getProperty() {
        return property;
    }

    public Geometry getGeometry() {
        return geometry;
    }

}
