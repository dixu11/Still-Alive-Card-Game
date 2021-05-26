package pl.dixu.sa.console;

import pl.dixu.sa.server.Controller;
import pl.dixu.sa.server.Presenter;
import pl.dixu.sa.server.cards.view.CardView;

import java.util.Scanner;

public class ConsolePresenter extends Presenter {

    private ConsoleGameView consoleGameView = new ConsoleGameView();
    private Scanner scanner = new Scanner(System.in);


    @Override
    public void playGeneral(CardView general) {
        printNoLine("Naciśnij enter aby rozpocząć");
        waitForEnter();
        displayGame();
        print("Zagrywasz kartę generała:");
        general.consoleDisplay();
        waitForEnter();
    }

    @Override
    public void showEnemyEvent(CardView event) {
        displayGame();
        print((event.isEnemy() ? "Wróg zagrywa " : "Zagrywasz ") + "kartę ");
        event.consoleDisplay();
        waitForEnter();
    }

    @Override
    public void showSpawnCharacter(CardView character) {
        displayGame();
        print("Na stół trafia:");
        character.consoleDisplay();
        waitForEnter();
    }

    private void displayGame() {
        consoleGameView.setGame(controller.getGameState());
        consoleGameView.display();
    }

    private void print(String text) {
        System.out.println(text + "\n");
    }
    private void printNoLine(String text){
        System.out.print(text);
    }

    private void waitForEnter() {
        scanner.nextLine();
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
