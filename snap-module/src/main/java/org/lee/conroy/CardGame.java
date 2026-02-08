package org.lee.conroy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardGame {
    private final String name;
    final List<Card> deckOfCards = new ArrayList<>();
    protected final List<Card> displayPile = new ArrayList<>();

    private static final String[] suits = {"♥", "♦", "♣", "♠" };
    private static final String[] symbol = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private static final int[] value = {2,3,4,5,6,7,8,9,10,11,12,13,14};



    public CardGame(String name) {
        this.name = name;
        createDeck();

    }

    public void createDeck() {
        deckOfCards.clear();
        for (String suit : suits) {
            for (int i = 0; i < symbol.length; i++) {
                deckOfCards.add(new Card(suit, symbol[i], value[i]));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void getDeck() {
        for (Card card: deckOfCards) {
            System.out.println(card.symbol + " of " + card.suit );
        }
    }

    public void getDisplayPile() {
      for (Card card : displayPile) {
          this.toString(card);
      }


}
    public void dealCard() {

        displayPile.add(deckOfCards.removeFirst());
        this.getDisplayPile();
    }

    public List<Card> sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparing(card -> card.value));
        return deckOfCards;
    }

    public List<Card> sortDeckIntoSuits() {
        deckOfCards.sort(Comparator.comparing(card -> card.suit));
        return deckOfCards;
    }
    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }


public void toString(Card card) {
    System.out.println(card.toString());
}



}

