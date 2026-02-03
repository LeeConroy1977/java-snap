package org.lee.conroy;


public class Main {
    public static void main(String[] args) {
        CardGame myGame = new CardGame("snap");
//        myGame.getDeck();
////        System.out.println();
////        myGame.sortDeckInNumberOrder();
////        myGame.getDeck();
////        System.out.println();
////        myGame.sortDeckIntoSuits();
////        myGame.getDeck();
////        System.out.println();
    myGame.shuffleDeck();
////        myGame.getDeck();
            myGame.dealCard();
            myGame.dealCard();
            myGame.getDisplayDeck();
            myGame.dealCard();
            myGame.getDisplayDeck();
        myGame.dealCard();
        myGame.getDisplayDeck();


    }

}

