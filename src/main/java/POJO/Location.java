package POJO;

public class Location {
    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    private double lat;
    private double lng;

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
