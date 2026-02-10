package game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Snap snap = new Snap("Snap");

        System.out.println("Welcome to " + snap.getName());

        System.out.println("Enter 1st player name:");
        snap.addPlayer(new Player(scanner.next()));

        System.out.println("Enter 2nd player name:");
        snap.addPlayer(new Player(scanner.next()));

        snap.startGame(scanner);

    }
}
