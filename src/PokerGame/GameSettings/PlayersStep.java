package PokerGame.GameSettings;

import PokerGame.GameSettings.CardsManipulations.CardsGiver;
import PokerGame.GameSettings.CardsManipulations.CardsPrinter;
import PokerGame.Models.Card;
import PokerGame.Models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayersStep {
    static Scanner in = new Scanner (System.in);

    public static void PlayerDoStep(Player p, List<Card> cards){
        System.out.println(" * * *");
        System.out.println("Ruch gracza Player " + p.getId());
        System.out.println("Podaj liczbe kart do wymiany");
        String line = in.nextLine();
        int liczbaDoWymiany = Integer.parseInt(line);
        if(liczbaDoWymiany != 0){
            System.out.println("Wskaż karty do wymiany (do wymiany)");
            line = in.nextLine();
            String[] values = line.split(" ");
            if(values.length != liczbaDoWymiany) {
                System.out.println("Podaleś nieprawidlową liczbe wymian. Nie otrzymasz wymian.");
                return;
            }
            else{
                List<Card> tmpList = new ArrayList<>();
                for(int i = 0; i < liczbaDoWymiany; i++){
                    tmpList.add(p.getCards().get(Integer.parseInt(values[i]) - 1));
                }
                p.getCards().removeAll(tmpList);
                System.out.println("Pozostale karty gracza " + p);
                CardsGiver.giveCardsToPlayer(p,cards);
                System.out.println("Po dobraniu kart przez gracza " + p);
            }
        }
    }
    public static void PlayerChooseCard(Player player, List<Card> cards){
        System.out.println("Hi, you see remaining cards.");
        System.out.println("Talia");
        CardsPrinter.printCardsRezyserowana(cards);
        System.out.println("Choose cards. Write 5 integers. Count from left side");
        String line = in.nextLine();
        String[] values = line.split(" ");
        if(values.length == 5){
            for(int i = 0; i < 5; i++){
                player.addCard(cards.get(Integer.parseInt(values[i])-1));
            }
        }
        else{
            System.out.println("Sorry!!!! You wrote incorrect");
        }
        cards.removeAll(player.getCards()); //remove card from deck
    }
}
