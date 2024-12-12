package PokerGame.Combinations;

import PokerGame.Combinations.PrimitiveChecks.*;
import PokerGame.Enums.CardValue;
import PokerGame.Enums.Combination;
import PokerGame.Models.Card;
import PokerGame.Models.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class EndCombinationCounter {

     class CombinationInfo{
        public Combination combination;
        public List<CardValue> cardValues = new ArrayList<>();
        public void add(Combination combination, List<CardValue> cardValues){
            this.combination = combination;
            this.cardValues.addAll(cardValues);
        }
    }

    public void CountCombination(Player player){
        Combination combination = Combination.HighCard;
        HashMap<CardValue, Integer> CountMap = new HashMap<>();
        RepeatCounter.countHowManyRepeat(player.getCards(), CountMap);

        boolean FlashCheck = false;
        boolean StraightCheck = false;

        FlashCheck = FlashCheker.testFlash(player.getCards()); // is flash
        StraightCheck = StraightChecker.testStraight(player.getCards()); // is straight
        if(FlashCheck && StraightCheck){
            if(player.getCards().
                    get(player.getCards().size()-1).
                    getValue() == CardValue.Ace){
                player.setCombination(Combination.RoyalFlash, CardValue.Ace);
                return;
            }
            else{
                player.setCombination(Combination.StraightFlush, player.getCards().
                        get(player.getCards().size()-1).getValue());
                return;
            }
        }
        if(FlashCheck){
            player.setCombination(Combination.Flush, player.getCards().
                    get(player.getCards().size()-1).getValue());
            return;
        }
        if(StraightCheck){
            player.setCombination(Combination.Straight, player.getCards().
                    get(player.getCards().size()-1).getValue());
            return;
        }
        CombinationInfo combinationInfo = new CombinationInfo();
        combinationInfo = testPowtor(player.getCards(), CountMap);
        Collections.sort(combinationInfo.cardValues);
        player.setCombination(combinationInfo.combination, combinationInfo.cardValues.get(combinationInfo.cardValues.size()-1));

    }


    private CombinationInfo testPowtor(List<Card> cards, HashMap<CardValue, Integer> CountMap){
        CombinationInfo map = new CombinationInfo();
        List<CardValue> values = new ArrayList<>();


        if(CountMap.containsValue(4)){
            for(CardValue c: CountMap.keySet()){
                if(CountMap.get(c) == 4){
                    values.add(c);
                }
            }
            map.add(Combination.FourOfKind, values);
            return map;
        } // check FourOfKind before next if

        // its if for FourOfKind and FullHouse == true
        if(CountMap.keySet().size()==2){
            CardValue tempValue = ValueOf3Checker.checkValueOf3(cards, CountMap);
            values.add(tempValue);
            CountMap.remove(tempValue);
            //values.add(checkValueOf2(cards, CountMap)); nie tak wazliwe, bo wygrajemy tymi trzema
            map.add(Combination.FullHouse, values);
            return map;
        }

        if(CountMap.containsValue(3)){
            map.add(Combination.ThreeOfKind, Collections.singletonList(ValueOf3Checker.checkValueOf3(cards, CountMap)));
            return map;
        }
        if(CountMap.containsValue(2)){
            CardValue tempValue = ValueOf2Checker.checkValueOf2(cards, CountMap);
            values.add(tempValue);
            CountMap.remove(tempValue);

            if(CountMap.containsValue(2)){
                values.add(ValueOf2Checker.checkValueOf2(cards, CountMap));
                map.add(Combination.TwoPairs, values);
            }
            else{
                map.add(Combination.Pair, values);
            }
            return map;
        }

        map.add(Combination.HighCard,Collections.singletonList(cards.get(cards.size()-1).getValue()));
        return map;
    }

}
