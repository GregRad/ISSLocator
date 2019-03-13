package pl.gregrad.isslocator;


import java.io.IOException;
import java.util.Scanner;

import static pl.gregrad.isslocator.IssData.getIssData;
import static pl.gregrad.isslocator.Menu.menu;
import static pl.gregrad.isslocator.TimeFormat.timeConverter;
import static pl.gregrad.isslocator.CoordinatesFormat.coordinates;
import static pl.gregrad.isslocator.IssDetails.calculateDistance;
import static pl.gregrad.isslocator.IssDetails.calculateSpeed;
import static pl.gregrad.isslocator.IssDetails.calculateTime;
import static pl.gregrad.isslocator.IssDetails.issFinalPositionParameters;
import static pl.gregrad.isslocator.IssDetails.issStartPositionParameters;

public class App {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
                int choice = menu();
                int end = 3;

                while (choice != end) {
                    switch (choice) {
                        case 1:
                            long currentPositionTime = getIssData().getTime();
                            double currentPositionLongitude = getIssData().getLongitude();
                            double currentPositionLatitude = getIssData().getLatitude();
                            System.out.println("Czas lokalny:");
                            timeConverter(currentPositionTime);
                            System.out.println("Pozycja stacji: ");
                            coordinates(currentPositionLongitude, currentPositionLatitude);
                            break;
                        case 2:
                            IssDetails startPositionData = issStartPositionParameters();
                            IssDetails finalPositionData = issFinalPositionParameters();
                            double distance = calculateDistance(
                                    startPositionData.getStartPositionLatitude(),
                                    startPositionData.getStartPositionLongitude(),
                                    finalPositionData.getFinalPositionLatitude(),
                                    finalPositionData.getFinalPositionLongitude());
                            long time = calculateTime(
                                    startPositionData.getStartPositionTime(),
                                    finalPositionData.getFinalPositionTime());
                            double speed = calculateSpeed(distance, time);

                            System.out.println("Stacja pokonała: " + String.format("%.2f", distance) + " km" + ", w czasie: " + time + " sekund");
                            System.out.println("Aktualna prędkość stacji wynosi: " + String.format("%.2f", (speed * 3600)) + " km/h");
                            break;
                        default:
                            System.out.println("Nieprawidłowy wybór, wybierz liczbę od 1 do 3");
                    }
                    System.out.println("\nNaciciśnij ENTER, aby wybrać ponownie.");
                    sc.nextLine();
                    choice = menu();
                }
                System.out.println("\nKoniec programu");
    }
}
