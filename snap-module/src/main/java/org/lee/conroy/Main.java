package org.lee.conroy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Snap snap = new Snap("Snap");

        System.out.println("Welcome to " + snap.getName());
        System.out.println("Press ENTER to deal a card...");
        System.out.println("-------------------------------");

        snap.shuffleDeck();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            scanner.nextLine();
            snap.dealCard();

            if (snap.isSnap()) {
                System.out.println("\nSNAP! User wins!");
                break;
            }

            if (!snap.hasCardsLeft()) {
                System.out.println("\nThe deck is empty. Game over.");
                break;
            }
        }

        scanner.close();
    }
}
