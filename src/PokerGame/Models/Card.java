package PokerGame.Models;

import PokerGame.Enums.CardValue;
import PokerGame.Enums.Suit;

public class Card implements Comparable<Card> {
    Suit cardSuit;
    CardValue value;

    public Suit getCardSuit() {
        return cardSuit;
    }

    public Card() {
    }
    public Card(CardValue value) {
        this.value = value;
    }
    public Card(Suit cardSuit, CardValue value) {
        this.cardSuit = cardSuit;
        this.value = value;
    }

    public void setCardSuit(Suit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value+cardSuit.toString();
    }

    @Override
    public int compareTo(Card o) {
        int result = value.compareTo(o.value);
        if (result == 0) {
            result = cardSuit.compareTo(o.cardSuit);
        }
        return result;
    }
}
