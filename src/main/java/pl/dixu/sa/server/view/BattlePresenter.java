package pl.dixu.sa.server.view;

import pl.dixu.sa.server.battle.Battle;
import pl.dixu.sa.server.command.PlayCardCommand;

//todo should be split into smaller
public abstract class BattlePresenter {

    protected Battle battle;

    public abstract void spawn(CardAttributes character);

    public void startBattle(Battle battle) {
        this.battle = battle;
        showStartBattle();
    }

    public abstract void showStartBattle();

    public abstract void playCard(PlayCardCommand command);

    public abstract void addEnergy(int energy);
}
