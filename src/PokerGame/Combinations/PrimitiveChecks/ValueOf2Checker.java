package PokerGame.Combinations.PrimitiveChecks;

import PokerGame.Enums.CardValue;
import PokerGame.Models.Card;

import java.util.HashMap;
import java.util.List;

public class ValueOf2Checker {
    public static CardValue checkValueOf2(List<Card> cards, HashMap<CardValue, Integer> CountMap){
        for(CardValue c: CountMap.keySet()){
            if(CountMap.get(c) == 2){
                return c;
            }
        }
        return CardValue.Nine;
    }

}
