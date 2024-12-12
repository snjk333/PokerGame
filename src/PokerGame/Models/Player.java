package PokerGame.Models;

import PokerGame.Enums.CardValue;
import PokerGame.Enums.Combination;

import java.util.ArrayList;
import java.util.Collections;

public class Player {

    private final int id;
    private ArrayList<Card> cards = new ArrayList<>();
    private Combination combination;
    private CardValue combinationValue;


    public Player(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
        Collections.sort(this.cards);
    }

    public Combination getCombination() {
        return combination;
    }

    public CardValue getCombinationValue() {
        return combinationValue;
    }

    public void setCombination(Combination combination, CardValue combinationValue) {
        this.combination = combination;
        this.combinationValue = combinationValue;
    }
    public void addCard(Card card){
        this.cards.add(card);
        Collections.sort(this.cards);
    }
    public void removeCardByCard(Card card){
        this.cards.remove(card);
        Collections.sort(this.cards);
    }
    public void removeCardByID(int id){
        this.cards.remove(id);
        Collections.sort(this.cards);
    }
    @Override
    public String toString() {
        return "Player " + id + ": " + cards;
    }
}
