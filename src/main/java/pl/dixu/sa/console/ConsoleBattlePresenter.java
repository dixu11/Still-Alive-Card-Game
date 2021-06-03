package pl.dixu.sa.console;

import pl.dixu.sa.console.decision.DecisionFactory;
import pl.dixu.sa.game.battle.Player;
import pl.dixu.sa.game.cards.effect.TargetableEffect;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.presenter.BattlePresenter;

import java.util.List;

import static pl.dixu.sa.console.Utils.*;

public class ConsoleBattlePresenter extends BattlePresenter {
    private ConsoleBattleView consoleGameView = new ConsoleBattleView();
    private DecisionFactory decisionFactory = new DecisionFactory();
    private ConsoleDialogController consoleDialogController;



    @Override
    public void onBattleSetup() {
        consoleDialogController = new ConsoleDialogController(battleLogicController);
    }

    @Override
    public void showStartBattle() {
        printNoLine("Rozpoczyna się bitwa!");
        // waitForEnter();
    }

    @Override
    public void spawn(CardAttributes character) {
        displayGame();
        print("Na stół trafia:");
        character.consoleDisplay();
        //waitForEnter();
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
    public void playRound() {
        waitForEnter();
        displayGame();
        consoleDialogController.playRound();
    }

    @Override
    public int chooseTarget(TargetableEffect effect, List<Area> possibleTargets) {
        return consoleDialogController.chooseTarget(effect,possibleTargets);
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

    private void displayGame() {
        consoleGameView.setBattle(battleLogicController.toDTO());
        consoleGameView.display();
    }

    private void printNoLine(String text){
        System.out.print(text);
    }
}
