package jp.co.myself.xacdonald.model.webapi.shop;

public class Feature {

    private String name;

    private Property property;

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
