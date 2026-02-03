package org.lee.conroy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private String name;
    private Card lastCard;
    private Card dealtCard;
    ArrayList<Card> deckOfCards = new ArrayList<>(52);
    ArrayList<Card> displayDeck = new ArrayList<>(52);

    String[] suits = {"♥", "♦", "♣", "♠" };
    String[] symbol = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    int[] value = {2,3,4,5,6,7,8,9,10,11,12,13,14};



    public CardGame(String name) {
        this.name = name;
        for (int i = 0; i < suits.length ; i++) {
            for (int j = 0; j < symbol.length; j++) {
                deckOfCards.add(new Card(suits[i], symbol[j], value[j]));
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

    public void getDisplayDeck() {
        lastCard = displayDeck.get(displayDeck.size() - 2);
        dealtCard = displayDeck.getLast();
        displayCard(lastCard);
        displayCard(dealtCard);
}
    public void dealCard() {
        displayDeck.add(deckOfCards.remove(0));
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparing(card -> card.value));
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        deckOfCards.sort(Comparator.comparing(card -> card.suit));
        return deckOfCards;
    }
    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }


public static void  displayCard(Card card) {
    System.out.println(card.symbol + " " + card.suit);
}


    }

