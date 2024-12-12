package PokerGame.Models;

import PokerGame.Enums.CardValue;
import PokerGame.Enums.Suit;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    List<Card> deckOfCards = new ArrayList<>();

    public CardDeck() {
        List<Card> listOfValues = new ArrayList<>();

        listOfValues.add(new Card(CardValue.Nine));
        listOfValues.add(new Card(CardValue.Ten));
        listOfValues.add(new Card(CardValue.Jack));
        listOfValues.add(new Card(CardValue.Queen));
        listOfValues.add(new Card(CardValue.King));
        listOfValues.add(new Card(CardValue.Ace));

        List<Card> listOfHeart = new ArrayList<>();
        List<Card> listOfTile = new ArrayList<>();
        List<Card> listOfClover = new ArrayList<>();
        List<Card> listOfPike = new ArrayList<>();

        for (Card card : listOfValues) {
            listOfHeart.add(new Card(Suit.HEART, card.getValue()));
            listOfTile.add(new Card(Suit.TILE, card.getValue()));
            listOfClover.add(new Card(Suit.CLOVER, card.getValue()));
            listOfPike.add(new Card(Suit.PIKE, card.getValue()));
        }

        deckOfCards.addAll(listOfHeart);
        deckOfCards.addAll(listOfTile);
        deckOfCards.addAll(listOfClover);
        deckOfCards.addAll(listOfPike);
    }

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }
    public void removeCard(Suit key, CardValue value){
        if(deckOfCards.contains(new Card(key,value))) {
            for (Card C : deckOfCards){
                if(C.equals(new Card(key,value))){
                    deckOfCards.remove(C);
                }
            }
        }
        else{
            System.out.println("I can't delete this card. ");
        }
    }
    public Card getCard(Suit key, CardValue value){
        Card card = new Card();
        for (Card C : deckOfCards){
            if(C.equals(new Card(key,value))){
                card = C;
            }
        }
        return card;
    }
}
