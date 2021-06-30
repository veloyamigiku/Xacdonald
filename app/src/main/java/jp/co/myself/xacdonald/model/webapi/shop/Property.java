package jp.co.myself.xacdonald.model.webapi.shop;

public class Property {

    private String address;

    private String tel1;

    private Station station;

    public Property(String address, String tel1, Station station) {
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

    public Station getStation() {
        return station;
    }

}
