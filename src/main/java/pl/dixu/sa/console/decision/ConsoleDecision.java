package pl.dixu.sa.console.decision;

import pl.dixu.sa.game.view.model.BattleDTO;
import pl.dixu.sa.game.view.presenter.PlayerDecision;

public abstract class ConsoleDecision implements PlayerDecision {

    protected String input;
    protected BattleDTO battle;

    public ConsoleDecision(String input, BattleDTO battle) {
        this.input = input;
        this.battle = battle;
    }

    public abstract void consolePresenterEffect();


}
