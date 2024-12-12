package PokerGame.GameSettings;

import PokerGame.Models.Player;

public class TieSolver {
    public static Player TieWinnerCheck(Player p1, Player p2) {
        if(p1.getCards().size() == p2.getCards().size()) {
            for(int i = p1.getCards().size()-1; i > -1; i--) {
                if(p1.getCards().get(i).getValue() != p2.getCards().get(i).getValue()) {
                    if(p1.getCards().get(i).getValue().getWeight() > p2.getCards().get(i).getValue().getWeight()) {
                        return p1;
                    }
                    else{
                        return p2;
                    }
                }
            }
        }
        return null;
    }
}