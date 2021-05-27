package pl.dixu.sa.console;

import pl.dixu.sa.server.view.CardView;
import pl.dixu.sa.server.view.BattlePresenter;

import java.util.Scanner;

public class ConsoleBattlePresenter extends BattlePresenter {

    private Scanner scanner = new Scanner(System.in);

    private ConsoleBattleView consoleGameView = new ConsoleBattleView();
    @Override
    public void spawn(CardView character) {
        displayGame();
        print("Na stół trafia:");
        character.consoleDisplay();
        waitForEnter();
    }

    @Override
    public void showStartBattle() {
        System.out.println("Rozpoczyna się bitwa!");
    }

    private void print(String text) {
        System.out.println(text + "\n");
    }

    private void waitForEnter() {
        scanner.nextLine();
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    //todo refactor
    public void playGeneral(CardView general) {
        printNoLine("Naciśnij enter aby rozpocząć");
        waitForEnter();
        displayGame();
        print("Zagrywasz kartę generała:");
        general.consoleDisplay();
        waitForEnter();
    }
    public void showEnemyEvent(CardView event) {
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