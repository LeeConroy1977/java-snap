package game;

import java.util.*;
import java.util.concurrent.*;

public class Snap extends CardGame{
    private final List<Player> players = new ArrayList<Player>(2);
    private final Random RANDOM = new Random();

    public Snap(String name) {
        super(name);
    }

    protected boolean isSnap() {
        if  (displayPile.size() < 2) return false;

        Card last = displayPile.getLast();
        Card secondLast = displayPile.get(displayPile.size() - 2);

        return last.getValue() == secondLast.getValue();
    }

    protected boolean hasCardsLeft() {
        return !super.deckOfCards.isEmpty();
    }

    protected PlayerAndIndex getRandomStartingPlayer() {
        int index = RANDOM.nextInt(players.size());
        return new PlayerAndIndex(players.get(index), index);
    }

   public  record PlayerAndIndex(Player player, int index) {}

    protected void addPlayer(Player player) {
        players.add(player);
    }

    protected List<Player> getPlayers() {
        return List.copyOf(players);
    }

    protected void startGame(Scanner scanner) throws ExecutionException, InterruptedException, TimeoutException {
        Timer myTimer = new Timer();
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
                System.out.println("Quick.....Type snap to win.......");
                ExecutorService executor = Executors.newSingleThreadExecutor();
                Future<String> futureInput = executor.submit(() -> {
                    byte[] inputBytes = new byte[20];
                    int bytesRead = System.in.read(inputBytes);
                    return new String(inputBytes, 0, bytesRead).trim();
                });

                try {
                    String winInput = futureInput.get(2, TimeUnit.SECONDS);
                    if ("snap".equalsIgnoreCase(winInput.trim())) {
                        System.out.println("SNAP! " + activePlayer.name() + " Wins!");
                        break;
                    } else {
                        System.out.println("Wrong input! You lose SLOW SNAPPER...");
                        break;
                    }
                } catch (TimeoutException e) {
                    System.out.println("Too slow! You lose SLOW SNAPPER...");
                    futureInput.cancel(true);
                    break;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    executor.shutdownNow();
                }
            }

            if (!hasCardsLeft()) {
                System.out.println("\nThe deck is empty. Game over.");
                break;
            }

            activeIndex = (activeIndex + 1) % 2;
            activePlayer = getPlayers().get(activeIndex);
        }

        scanner.close();
    }



}
