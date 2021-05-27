package pl.dixu.sa.server.core;

import pl.dixu.sa.server.battle.Battle;
import pl.dixu.sa.server.battle.BattleFactory;

//global game service (all game stages, even outside battles)
public class Gameplay {

    private BattleFactory battleFactory;

   public Gameplay(BattleFactory battleFactory) {
        this.battleFactory = battleFactory;
    }
    public void startGame() {
        startGameplay();
    }

    private void startGameplay() {
        startBattle();
    }

    private void startBattle() {
        Battle battle = battleFactory.createBattle();
        battle.start();
    }
}
