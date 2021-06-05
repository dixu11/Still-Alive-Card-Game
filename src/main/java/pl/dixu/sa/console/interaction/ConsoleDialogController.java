package pl.dixu.sa.console.interaction;

import pl.dixu.sa.game.cards.effect.TargetableEffect;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.view.model.BattleDTO;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.presenter.BattleController;
import pl.dixu.sa.game.view.presenter.PlayerController;
import pl.dixu.sa.game.view.presenter.PlayerDecision;

import java.util.List;
import java.util.Scanner;

import static pl.dixu.sa.console.interaction.DecisionType.*;
import static pl.dixu.sa.console.Utils.print;
import static pl.dixu.sa.console.Utils.shortPrint;

public class ConsoleDialogController {

    private BattleDTO battleDTO;
    private List<CardAttributes> hand;
    private BattleController battleController;
    private DecisionFactory decisionFactory = new DecisionFactory();

    public ConsoleDialogController(BattleController battleController) {
        this.battleController = battleController;
        updateData();
    }

    private void updateData() {
        battleDTO = battleController.toDTO();
        hand = battleDTO.hand;
    }

    public void playAction() {
        updateData();
        printStats();
        printCards(hand);
        printOtherOptions();
        System.out.println("Którą opcję wybierasz?");
        PlayerDecision playerDecision = readDecision();
        System.out.println("Wykonujesz decycje: " + playerDecision);
        battleController.executeDecision(playerDecision);
    }

    private void printStats() {
        shortPrint("Twoja energia: " + battleDTO.energy);
    }

    private void printCards(List<CardAttributes> hand) {
        System.out.println("Zagraj kartę:");
        for (int i = 0; i < hand.size(); i++) {
            shortPrint(i + 1 + ": " + hand.get(i).asLine());
        }
    }

    private void printOtherOptions() {
        shortPrint(SHOP_BUY_1.getShortcut()+ ": kup Generator/ulepszenie");
        shortPrint(SHOP_BUY_2.getShortcut()+": kup Obrońcę/ulepszenie");
        shortPrint(DRAW.getShortcut()+": Dociągnij kartę za 1 energii");
        shortPrint(END_TURN.getShortcut()+ ": Zakończ turę");
        shortPrint(CARD_INFO.getShortcut()+ ": Opisy kart");
        shortPrint(END_GAME.getShortcut()+ ": Zakończ grę");
    }

    private PlayerDecision readDecision() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            DecisionType decision = DecisionType.findByShortcut(input);

            switch (decision){
                case SHOP_BUY_1:
                    return player ->  player.buyShopCard(0);
                case SHOP_BUY_2:
                    return player ->  player.buyShopCard(1);
                case DRAW:
                    return PlayerController::buyDraw;
                case END_TURN:
                    return PlayerController::endTurn;
                case END_GAME:
                    return null;//todo
                case CARD_INFO:
                    return null; //todo
                case INVALID:
                    return null;//todo
                case PLAY_CARD:
                    if (isCard(input)) {
                        int cardIndex = Integer.parseInt(input) - 1;
                        shortPrint("Zagrywasz kartę: " + hand.get(cardIndex));
                        return player -> player.playCard(hand.get(cardIndex).getId());
                    }
                default:
                    return null;
            }

        } catch (
                IllegalArgumentException e) {
            shortPrint(e.getMessage() );
            return readDecision();
        }

    }

    private boolean isCard(String input) {
        int cardIndex = Integer.parseInt(input);
        return cardIndex >= 0 && cardIndex <= hand.size();
    }

    private void playCard(String decision) {

    }

    private void playOtherOption(String decision) {

    }

    private void executeDecision() {

    }

    public void chooseTarget(TargetableEffect effect, List<Area> possibleTargets) {
        print("Wybierz cel efektu " + effect.toAttributes().name());
       List<CardAttributes> targets = battleDTO.getByAreasWithEmptySlots(possibleTargets);
        for (int i = 0; i <targets.size(); i++) {
            shortPrint(i + 1 + ". " + targets.get(i).name());
        }
        int input = readInt(targets.size());
        CardAttributes target = targets.get(input - 1);
        int id = target.getId();
        battleController.executeDecision(player -> player.executeEffectWithTarget(id));
    }

    private int readInt(int max) {
        Scanner scanner = new Scanner(System.in);
        try {
            int input = scanner.nextInt();
            if (input > max || input <= 0) {
                shortPrint("Prawidłowy zakres: " + 1 + " - " + max);
                input = readInt(max);
            }
            return input;
        } catch (IllegalArgumentException e) {
            shortPrint("Należy podać liczbę!");
            return readInt(max);
        }
    }
}
