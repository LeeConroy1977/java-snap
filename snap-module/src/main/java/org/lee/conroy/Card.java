package org.lee.conroy;

public class Card {
    public String suit;
    public String symbol;
    public int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public void displayCard() {
        System.out.println("This card has the symbol: " + symbol + "\n" + "the suit  " + suit + "\n" + " The value " + value);
    }

}
