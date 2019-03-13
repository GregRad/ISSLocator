package pl.gregrad.isslocator;


import java.util.Objects;
import java.util.Scanner;

import static pl.gregrad.isslocator.IssData.getIssData;

public class IssDetails {

    private double startPositionLatitude;
    private double startPositionLongitude;
    private double finalPositionLatitude;
    private double finalPositionLongitude;
    private long startPositionTime;
    private long finalPositionTime;

    public double getStartPositionLatitude() {
        return startPositionLatitude;
    }

    public void setStartPositionLatitude(double startPositionLatitude) {
        this.startPositionLatitude = startPositionLatitude;
    }

    public double getStartPositionLongitude() {
        return startPositionLongitude;
    }

    public void setStartPositionLongitude(double startPositionLongitude) {
        this.startPositionLongitude = startPositionLongitude;
    }

    public double getFinalPositionLatitude() {
        return finalPositionLatitude;
    }

    public void setFinalPositionLatitude(double finalPositionLatitude) {
        this.finalPositionLatitude = finalPositionLatitude;
    }

    public double getFinalPositionLongitude() {
        return finalPositionLongitude;
    }

    public void setFinalPositionLongitude(double finalPositionLongitude) {
        this.finalPositionLongitude = finalPositionLongitude;
    }

    public long getStartPositionTime() {
        return startPositionTime;
    }

    public void setStartPositionTime(long startPositionTime) {
        this.startPositionTime = startPositionTime;
    }

    public long getFinalPositionTime() {
        return finalPositionTime;
    }

    public void setFinalPositionTime(long finalPositionTime) {
        this.finalPositionTime = finalPositionTime;
    }

    public static long calculateTime(long startPositionTime, long finalPositionTime) {
        return finalPositionTime - startPositionTime;
    }

    public static double calculateDistance(double startPositionLatitude, double startPositionLongitude, double finalPositionLatitude, double finalPositionLongitude){

        final double R = 6371.16;

        double dLon = Math.toRadians(finalPositionLongitude-startPositionLongitude);
        double dLat = Math.toRadians(finalPositionLatitude-startPositionLatitude);

        double a = (Math.sin(dLat / 2) * Math.sin(dLat / 2)) +
                (Math.cos(Math.toRadians(startPositionLatitude))) *
                        (Math.cos(Math.toRadians(finalPositionLatitude))) *
                        (Math.sin(dLon / 2)) *
                        (Math.sin(dLon / 2));
        double angle = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return angle*R;
    }

    public static double calculateSpeed(double distance, long time) {
        return distance/time;
    }

    public static IssDetails issStartPositionParameters() {
        IssDetails issStartDetails = new IssDetails();
        System.out.println("Wciśniej ENTER, aby pobrać aktualną pozycję i rozpocząć pomiar");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Rozpocząto pomiar...\n");
        issStartDetails.setStartPositionLatitude(getIssData().getLatitude());
        issStartDetails.setStartPositionLongitude(getIssData().getLongitude());
        issStartDetails.setStartPositionTime(getIssData().getTime());

        return issStartDetails;
    }
    public static IssDetails issFinalPositionParameters() {
        IssDetails issFinalDetails = new IssDetails();
        System.out.println("Wciśniej ENTER, aby pobrać aktualną pozycję stacji i zakończyć pomiar");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        issFinalDetails.setFinalPositionLatitude(getIssData().getLatitude());
        issFinalDetails.setFinalPositionLongitude(getIssData().getLongitude());
        issFinalDetails.setFinalPositionTime(getIssData().getTime());
        System.out.println("Zakończono pomiar...");
        System.out.println("Obliczanie drogi i prędkości stacji...\n");

        return issFinalDetails;
    }

    @Override
    public String toString() {
        return "IssDetails{" +
                "startPositionLatitude=" + startPositionLatitude +
                ", startPositionLongitude=" + startPositionLongitude +
                ", finalPositionLatitude=" + finalPositionLatitude +
                ", finalPositionLongitude=" + finalPositionLongitude +
                ", startPositionTime=" + startPositionTime +
                ", finalPositionTime=" + finalPositionTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssDetails that = (IssDetails) o;
        return Double.compare(that.startPositionLatitude, startPositionLatitude) == 0 &&
                Double.compare(that.startPositionLongitude, startPositionLongitude) == 0 &&
                Double.compare(that.finalPositionLatitude, finalPositionLatitude) == 0 &&
                Double.compare(that.finalPositionLongitude, finalPositionLongitude) == 0 &&
                startPositionTime == that.startPositionTime &&
                finalPositionTime == that.finalPositionTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPositionLatitude, startPositionLongitude, finalPositionLatitude, finalPositionLongitude, startPositionTime, finalPositionTime);
    }
}
