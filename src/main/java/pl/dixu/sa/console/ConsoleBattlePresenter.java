package pl.dixu.sa.console;

import pl.dixu.sa.console.decision.ConsoleDecision;
import pl.dixu.sa.console.decision.DecisionFactory;
import pl.dixu.sa.game.battle.Player;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.view.model.BattleDTO;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.presenter.BattlePresenter;
import pl.dixu.sa.game.view.presenter.PlayerController;

import java.util.List;
import java.util.Scanner;

public class ConsoleBattlePresenter extends BattlePresenter {

    private Scanner scanner = new Scanner(System.in);
    private DecisionFactory decisionFactory = new DecisionFactory();
    private ConsoleBattleView consoleGameView = new ConsoleBattleView();
    @Override
    public void spawn(CardAttributes character) {
        displayGame();
        print("Na stół trafia:");
        character.consoleDisplay();
        waitForEnter();
    }

    @Override
    public void showStartBattle() {
        printNoLine("Rozpoczyna się bitwa!");
        waitForEnter();
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
    public void addEnergy(int energy) {
        shortPrint("Dostajesz " + energy + " energii");
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

    @Override
    public void playRound(PlayerController controller) {
        waitForEnter();
        displayGame();

        BattleDTO battleDTO = battle.toDTO();
        List<CardAttributes> hand = battleDTO.hand;

        printCards(hand);
        printOtherOptions();
        System.out.println("Którą opcję wybierasz?");
        ConsoleDecision consoleDecision = readDecision();
        consoleDecision.consolePresenterEffect();
        consoleDecision.execute(controller);

    }

    private void printCards(List<CardAttributes> hand) {
        System.out.println("Zagraj kartę:");
        for (int i = 0; i < hand.size(); i++) {
            shortPrint(i+1+": " + hand.get(0).asLine());
        }
    }

    private void printOtherOptions() {
        shortPrint("g: wykup Generator ze sklepu");
        shortPrint("o: wykup Obrońce ze sklepu");
        shortPrint("d: Dociągnij kartę za 1 energii");
        shortPrint("z: Zakończ turę");
        shortPrint("o: Opisy kart");
        shortPrint("w: Zakończ grę");
    }

    private ConsoleDecision readDecision() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try{
           return decisionFactory.createDecision(input);
        }catch (IllegalArgumentException e){
            shortPrint(e.getMessage());
            return readDecision();
        }
    }

    private void playCard(String decision) {

    }

    private void playOtherOption(String decision) {

    }

    private void executeDecision() {

    }

    private void shortPrint(String text){
        System.out.println(text);
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
