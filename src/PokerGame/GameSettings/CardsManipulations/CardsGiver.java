package PokerGame.GameSettings.CardsManipulations;

import PokerGame.Models.Card;
import PokerGame.Models.Player;

import java.util.List;

public class CardsGiver {
    public static void giveCardsToPlayer(Player p1, List<Card> cards ){
        int needCount = 5 - p1.getCards().size(); // np. 5
        for(int i = 0; i < needCount; i++){
            p1.addCard(cards.get(i*2));
        } //add card to player
        cards.removeAll(p1.getCards()); //remove card from deck
    }
}
