package PokerGame.GameSettings;

import PokerGame.Combinations.*;
import PokerGame.Models.Player;


public class WinTester {

    public Player CountWinner(Player p1, Player p2){

        EndCombinationCounter EndCombo = new EndCombinationCounter();
        EndCombo.CountCombination(p1);
        EndCombo.CountCombination(p2);

        if(p1.getCombination().getWeight() == p2.getCombination().getWeight()){
            if(p1.getCombinationValue().getWeight() == p2.getCombinationValue().getWeight()){
                return TieSolver.TieWinnerCheck(p1, p2);
            }
            else if (p1.getCombinationValue().getWeight() > p2.getCombinationValue().getWeight()) {
                return p1;
            }
            else{
                return p2;
            }
        }
        else if(p1.getCombination().getWeight() > p2.getCombination().getWeight()){
            return p1;
        }
        else return p2;

    }

}
