package PokerGame.Combinations.PrimitiveChecks;

import PokerGame.Models.Card;

import java.util.List;

public class StraightChecker {
    public static boolean testStraight(List<Card> cards){
        int start = cards.get(0).getValue().getWeight();

        for(int i = 1; i < cards.size(); i++){
            if(cards.get(i).getValue().getWeight() == start+1){
                start+=1;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
