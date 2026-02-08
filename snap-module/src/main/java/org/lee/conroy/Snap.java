package org.lee.conroy;

public class Snap extends CardGame{

    public Snap(String name) {
        super(name);
    }

    public boolean isSnap() {
        if (displayPile.size() < 2) {
            return false;
        }

        Card last = displayPile.getLast();
        Card secondLast = displayPile.get(displayPile.size() - 2);

        return last.getValue() == secondLast.getValue();
    }

    public boolean hasCardsLeft() {
        return !super.deckOfCards.isEmpty();
    }
}
