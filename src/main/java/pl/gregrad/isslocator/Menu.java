package pl.gregrad.isslocator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("ISSLocator");
        System.out.println("Wybierz akcję:");
        System.out.println("1. Wyświetl lokalizację stacji kosmicznej");
        System.out.println("2. Oblicz prędkość stacji kosmicznej i drogę jaką pokonała");
        System.out.println("3. Zakończ");

        try {
            System.out.println("\nPodaj liczbę od 1 do 3, następnie zatwierdź ENTEREM ");
            choice = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Musisz podać liczbę");
        }
        return choice;
    }
}
