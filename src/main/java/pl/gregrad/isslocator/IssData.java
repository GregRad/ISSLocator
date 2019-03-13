package pl.gregrad.isslocator;

import java.io.IOException;
import java.util.Objects;

import static pl.gregrad.isslocator.JsonConnector.jsonConnector;


public class IssData {
    private long time;
    private double longitude;
    private double latitude;

    public long getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public static IssData getIssData(){
        String url = "http://api.open-notify.org/iss-now.json";
        IssData data = new IssData();
        try {
            data.setTime(jsonConnector(url).get("timestamp").getAsInt());
            data.setLongitude(jsonConnector(url).getAsJsonObject("iss_position").get("longitude").getAsDouble());
            data.setLatitude(jsonConnector(url).getAsJsonObject("iss_position").get("latitude").getAsDouble());
        } catch (IOException io) {
            System.out.println("IO Execption");
            io.printStackTrace();
        }
        return data;
    }

    @Override
    public String toString() {
        return "IssData{" +
                "time=" + time +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssData issData = (IssData) o;
        return time == issData.time &&
                Double.compare(issData.longitude, longitude) == 0 &&
                Double.compare(issData.latitude, latitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, longitude, latitude);
    }
}