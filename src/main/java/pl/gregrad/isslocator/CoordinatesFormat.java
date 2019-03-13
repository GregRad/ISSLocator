package pl.gregrad.isslocator;


public class CoordinatesFormat {

    public static void coordinates(double longitude, double latitude) {
        char north = 'N';
        char south = 'S';
        char west = 'W';
        char east = 'E';
        if (latitude < 0) {
            System.out.println("Szerokość geograficzna: " + (latitude * (-1)) + " " + south);
        } else {
            System.out.println("Szerokość geograficzna: " + latitude + " " + north);
        }
        if (longitude < 0) {
            System.out.println("Długość geograficzna: " + (longitude * (-1)) + " " + west);
        } else {
            System.out.println("Długość geograficzna: " + longitude + " " + east);
        }
    }
}
