package PokerGame.Combinations.PrimitiveChecks;

import PokerGame.Enums.CardValue;
import PokerGame.Models.Card;

import java.util.HashMap;
import java.util.List;

public class RepeatCounter {
    public static void countHowManyRepeat(List<Card> cards, HashMap<CardValue, Integer> CountMap){
        // counting how many values we have in Cards
        for(Card card : cards){
            if(CountMap.containsKey(card.getValue())){
                CountMap.put(card.getValue(), (CountMap.get(card.getValue())+1));
            }
            else{
                CountMap.put(card.getValue(), 1);
            }
        }
    }
}
