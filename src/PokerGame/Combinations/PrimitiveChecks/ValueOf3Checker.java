package PokerGame.Combinations.PrimitiveChecks;

import PokerGame.Enums.CardValue;
import PokerGame.Models.Card;

import java.util.HashMap;
import java.util.List;

public class ValueOf3Checker {
    public static CardValue checkValueOf3(List<Card> cards, HashMap<CardValue, Integer> CountMap){
        for(CardValue c: CountMap.keySet()){
            if(CountMap.get(c) == 3){
                return c;
            }
        }
        return CardValue.Nine;
    }
}
