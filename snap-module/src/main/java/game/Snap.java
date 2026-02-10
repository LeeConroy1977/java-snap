package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Snap extends CardGame{
    private final List<Player> players = new ArrayList<Player>(2);
    private final Random RANDOM = new Random();

    public Snap(String name) {
        super(name);
    }

    protected boolean isSnap() {
        if (displayPile.size() < players.size()) {
            return false;
        }

        Card last = displayPile.getLast();
        Card secondLast = displayPile.get(displayPile.size() - 2);

        return last.getValue() == secondLast.getValue();
    }

    protected boolean hasCardsLeft() {
        return !super.deckOfCards.isEmpty();
    }

    protected PlayerAndIndex getRandomStartingPlayer() {
        int index = RANDOM.nextInt(players.size());
        return new PlayerAndIndex(players.get(index), index + 1);
    }

   public  record PlayerAndIndex(Player player, int index) {}

    protected void addPlayer(Player player) {
        players.add(player);
    }

    protected List<Player> getPlayers() {
        return List.copyOf(players);
    }

    protected void startGame(Scanner scanner) {
        Player activePlayer;
        int activeIndex;
        shuffleDeck();
        Snap.PlayerAndIndex starter = getRandomStartingPlayer();
        System.out.println("Player " + starter.index()  + " " +  starter.player().name() + " Starts the game! " +  "Press ENTER to deal a card...");
        System.out.println("-------------------------------");
        scanner.nextLine();
        activePlayer = starter.player();
        activeIndex = starter.index();

        while (true) {
            scanner.nextLine();
            System.out.println(activePlayer.name() + "'s  turn ");
            dealCard();


            if (isSnap()) {
                System.out.println("\nSNAP! "  +  activePlayer.name() + " Wins ");
                break;
            }

            if (!hasCardsLeft()) {
                System.out.println("\nThe deck is empty. Game over.");
                break;
            }

            activePlayer = getPlayers().get(activeIndex);
            activeIndex = (activeIndex + 1) % players.size();
        }

        scanner.close();
    }



}
