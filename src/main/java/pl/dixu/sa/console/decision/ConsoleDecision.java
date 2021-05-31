package pl.dixu.sa.console.decision;

import pl.dixu.sa.game.view.model.BattleDTO;
import pl.dixu.sa.game.view.presenter.PlayerDecision;

public abstract class ConsoleDecision implements PlayerDecision {

    protected String input;

    public ConsoleDecision(String input) {
        this.input = input;
    }

    public abstract void consolePresenterEffect();


}
