package org.lee.conroy;

public class Card {
    final String suit;
    final String symbol;
    final int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }


    public String toString() {
        return symbol + " " + suit;
    }

    public Object getValue() {
        return value;
    }
}
