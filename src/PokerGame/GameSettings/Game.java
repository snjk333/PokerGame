package PokerGame.GameSettings;

import PokerGame.GameSettings.CardsManipulations.CardsGiver;
import PokerGame.GameSettings.CardsManipulations.CardsPrinter;
import PokerGame.Models.Card;
import PokerGame.Models.CardDeck;
import PokerGame.Models.Player;

import java.util.*;

public class Game {
    Player player1 = new Player(1);
    Player player2 = new Player(2);

    public void PlayGraRezyserowana(){
        CardDeck newDeck = new CardDeck();

        List<Card> allCards = new ArrayList<>(newDeck.getDeckOfCards()); //zrobilem karty
        Collections.sort(allCards);
        PlayersStep.PlayerChooseCard(player1, allCards);
        PlayersStep.PlayerChooseCard(player2, allCards);

        System.out.println("Karty gracza " + player1.toString());
        System.out.println("Karty gracza " + player2.toString());

        if(player2.getCards().size()==5 && player1.getCards().size()==5){
            WinTester test = new WinTester();
            Player Winner = test.CountWinner(player1, player2);
            if(Winner == null){
                System.out.println("Nikt nie wygral");
            }
            else{
                System.out.println("Wygrana przez: Player " + Winner.getId());
            }
            System.out.println("Wynik gracza: Player " + player1.getId() + " to: " + player1.getCombination() + " : " + player1.getCards());
            System.out.println("Wynik gracza: Player " + player2.getId() + " to: " + player2.getCombination() + " : " + player2.getCards());
        }
    }

    public void playFirstGame(){
        CardDeck newDeck = new CardDeck();

        List<Card> allCards = new ArrayList<>(newDeck.getDeckOfCards()); //zrobilem karty
        Collections.sort(allCards);
        System.out.println("Talia");
        CardsPrinter.printCards(allCards);
        Collections.shuffle(allCards);

        System.out.println("Po tasowaniu");
        CardsPrinter.printCards(allCards);

        CardsGiver.giveCardsToPlayer(player1, allCards);
        CardsGiver.giveCardsToPlayer(player2, allCards);

        System.out.println("Karty gracza " + player1.toString());
        System.out.println("Karty gracza " + player2.toString());

        PlayersStep.PlayerDoStep(player1, allCards);
        PlayersStep.PlayerDoStep(player2, allCards);

        WinTester test = new WinTester();
        Player Winner = test.CountWinner(player1, player2);
        if(Winner == null){
            System.out.println("Nikt nie wygral");
        }
        else{
            System.out.println("Wygrana przez: Player " + Winner.getId());
        }
        System.out.println("Wynik gracza: Player " + player1.getId() + " to: " + player1.getCombination() + " : " + player1.getCards());
        System.out.println("Wynik gracza: Player " + player2.getId() + " to: " + player2.getCombination() + " : " + player2.getCards());
    }


}
