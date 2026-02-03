package org.lee.conroy;

import java.util.ArrayList;

public class CardGame {
    private String name;
    ArrayList<Card> deckOfCards = new ArrayList<>(52);

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


    }

