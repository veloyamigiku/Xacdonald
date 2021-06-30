package jp.co.myself.xacdonald.model.webapi.shop;

public class Station {

    private String name;

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
