package PokerGame.Combinations.PrimitiveChecks;

import PokerGame.Enums.Suit;
import PokerGame.Models.Card;

import java.util.List;

public class FlashCheker {
    public static boolean testFlash(List<Card> cards){
        Suit start = cards.get(0).getCardSuit();

        for(int i = 1; i < cards.size(); i++){
            if(start != cards.get(i).getCardSuit()){
                return false;
            }
        }
        return true;
    }
}
