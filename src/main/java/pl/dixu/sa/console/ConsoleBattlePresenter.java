package pl.dixu.sa.console;

import pl.dixu.sa.console.decision.DecisionFactory;
import pl.dixu.sa.game.battle.Player;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.presenter.BattleController;
import pl.dixu.sa.game.view.presenter.BattlePresenter;

import java.util.List;
import java.util.Scanner;

import static pl.dixu.sa.console.Utils.*;

public class ConsoleBattlePresenter extends BattlePresenter {
    private ConsoleBattleView consoleGameView = new ConsoleBattleView();
    private DecisionFactory decisionFactory = new DecisionFactory();

    @Override
    public void spawn(CardAttributes character) {
        displayGame();
        print("Na stół trafia:");
        character.consoleDisplay();
        //waitForEnter();
    }

    @Override
    public void showStartBattle() {
        printNoLine("Rozpoczyna się bitwa!");
       // waitForEnter();
    }

    @Override
    public void showCardPlayed(Player player, Card card) {
        displayGame();
        if (player.isEnemy()) {
            print("Przeciwnik zagrywa kartę: ");
        } else {
            print("Zagrywasz kartę: ");
        }
        print(card.getName());
        waitForEnter();
    }


    @Override
    public void playRound(BattleController battleController) {
        waitForEnter();
        displayGame();
        ConsoleController consoleController = new ConsoleController(battleController);
        consoleController.playRound();
    }

    @Override
    public void changeEnergy(int energy) {
        if (energy > 0) {
            shortPrint("Dostajesz " + energy + " energii");
        } else {
            shortPrint("Tracisz " + -energy + " energii");
        }
    }

    @Override
    public void showDraw(List<? extends Card> cards) {
        System.out.println("Dociągasz " + cards.size() + " kart");
    }

    @Override
    public void showShuffle() {
        print("Wtasowujesz wykorzystane karty do puli");
    }

    @Override
    public void showNewCard(EventCard card) {
        //todo
        System.out.println("Twoja nowa karta: ");
        card.toAttributes().consoleDisplay();
    }

    @Override
    public void showEndTurn() {
        //todo
        System.out.println("Zakończyłeś turę");
    }


    //todo refactor
    public void playGeneral(CardAttributes general) {
        printNoLine("Naciśnij enter aby rozpocząć");
        waitForEnter();
        displayGame();
        print("Zagrywasz kartę generała:");
        general.consoleDisplay();
        waitForEnter();
    }
    public void showEnemyEvent(CardAttributes event) {
        displayGame();
        print((event.isEnemy() ? "Wróg zagrywa " : "Zagrywasz ") + "kartę ");
        event.consoleDisplay();
        waitForEnter();
    }

    private void displayGame() {
        consoleGameView.setBattle(battle.toDTO());
        consoleGameView.display();
    }

    private void printNoLine(String text){
        System.out.print(text);
    }
}
