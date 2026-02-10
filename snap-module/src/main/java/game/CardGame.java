package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class CardGame {
    private final String name;
    protected final List<Card> deckOfCards = new ArrayList<>();
    protected final List<Card> displayPile = new ArrayList<>();

    private static final String[] suits = {"♥", "♦", "♣", "♠" };
    private static final String[] symbol = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};


    public CardGame(String name) {
        this.name = name;
        createDeck();

    }

    protected  void createDeck() {
        deckOfCards.clear();
        for (String suit : suits) {
            for (int i = 0; i < symbol.length; i++) {
                deckOfCards.add(new Card(suit, symbol[i], i+2));
            }
        }
    }

    public String getName() {
        return name;
    }

    protected  void getDeck() {
        for (Card card: deckOfCards) {
            System.out.println(card.symbol + " of " + card.suit );
        }
    }

    protected  void getDisplayPile() {
      for (Card card : displayPile) {
          toString(card);
      }


}
    protected  void dealCard() {
        if (deckOfCards.isEmpty()) {
            return;
        }

        Card card = deckOfCards.removeFirst();
        displayPile.add(card);
        getDisplayPile();
    }

    protected  List<Card> sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparing(card -> card.value));
        return deckOfCards;
    }

    protected  List<Card> sortDeckIntoSuits() {
        deckOfCards.sort(Comparator.comparing(Card::getSuit));
        return deckOfCards;
    }
    protected  void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }


    protected  void toString(Card card) {
    System.out.println(card);
}



}

