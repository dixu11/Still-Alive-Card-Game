package pl.dixu.sa.console;

import pl.dixu.sa.console.decision.DecisionFactory;
import pl.dixu.sa.game.view.model.BattleDTO;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.presenter.BattleController;
import pl.dixu.sa.game.view.presenter.PlayerController;
import pl.dixu.sa.game.view.presenter.PlayerDecision;

import java.util.List;
import java.util.Scanner;

import static pl.dixu.sa.console.Utils.shortPrint;

public class ConsoleController {

    private BattleDTO battleDTO;
    private List<CardAttributes> hand;
    private BattleController controller;
    private DecisionFactory decisionFactory = new DecisionFactory();

    public ConsoleController(BattleController controller) {
        battleDTO = controller.toDTO();
        hand = battleDTO.hand;
        this.controller = controller;
    }

    public void playRound() {
        printCards(hand);
        printOtherOptions();
        System.out.println("Którą opcję wybierasz?");
        PlayerDecision playerDecision = readDecision();
        System.out.println("Wykonujesz decycje: " + playerDecision);
        controller.executeDecision(playerDecision);
    }

    private void printCards(List<CardAttributes> hand) {
        System.out.println("Zagraj kartę:");
        for (int i = 0; i < hand.size(); i++) {
            shortPrint(i + 1 + ": " + hand.get(i).asLine());
        }
    }

    private void printOtherOptions() {
        shortPrint(DecisionType.SHOP_BUY_1.getShortcut()+ ": kup Generator/ulepszenie");
        shortPrint("o: kup Obrońcę/ulepszenie"); //todo
        shortPrint("d: Dociągnij kartę za 1 energii");
        shortPrint("z: Zakończ turę");
        shortPrint("o: Opisy kart");
        shortPrint("w: Zakończ grę");
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
}
