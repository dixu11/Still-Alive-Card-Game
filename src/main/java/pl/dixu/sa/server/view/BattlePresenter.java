package pl.dixu.sa.server.view;

import pl.dixu.sa.server.battle.Battle;

//todo should be split into smaller
public abstract class BattlePresenter {

    protected Battle battle;

    public abstract void spawn(CardView character);

    public void startBattle(Battle battle) {
        this.battle = battle;
    }

    public abstract void showStartBattle();
}
