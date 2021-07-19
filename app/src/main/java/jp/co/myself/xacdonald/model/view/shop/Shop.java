package jp.co.myself.xacdonald.model.view.shop;

public class Shop {

    private String name;

    private String address;

    private String tel;

    private String station;

    private String railway;

    private Double lat;

    private Double lon;

    private Float dist;

    public Shop(
            String name,
            String address,
            String tel,
            String station,
            String railway,
            Double lat,
            Double lon,
            Float dist) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.station = station;
        this.railway = railway;
        this.lat = lat;
        this.lon = lon;
        this.dist = dist;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public String getStation() {
        return station;
    }

    public String getRailway() {
        return railway;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public Float getDist() {
        return dist;
    }

}
