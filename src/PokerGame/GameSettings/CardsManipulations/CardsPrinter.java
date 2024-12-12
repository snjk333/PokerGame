package PokerGame.GameSettings.CardsManipulations;

import PokerGame.Models.Card;

import java.util.List;

public class CardsPrinter {
    public static void printCards(List<Card> cards){
        for(Card card : cards){
            if(cards.indexOf(card) != cards.size()-1){
                System.out.print(card + ", ");
            }
            else{
                System.out.print(card);
            }
        }
        System.out.println();
    }

    public static void printCardsRezyserowana(List<Card> cards){
        int counter = 0;
        for(Card card : cards){
            counter++;
            if(cards.indexOf(card) != cards.size()-1){
                System.out.print(counter + ": " + card + ", ");
            }
            else{
                System.out.print(counter + ": " + card);
            }
        }
        System.out.println();
    }
}
