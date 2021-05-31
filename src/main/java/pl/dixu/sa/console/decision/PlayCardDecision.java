package pl.dixu.sa.console.decision;

import pl.dixu.sa.console.Utils;
import pl.dixu.sa.game.view.model.BattleDTO;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.presenter.PlayerController;

public class PlayCardDecision extends ConsoleDecision {
    private CardAttributes card;

    public PlayCardDecision(String input, CardAttributes card) {
        super(input);
        this.card = card;
    }

    @Override
    public void consolePresenterEffect() {
        Utils.shortPrint("Zagrywasz kartę: " + card.name());
    }

    @Override
    public void execute(PlayerController player) {
        player.playCard(card.getId());
    }
}
