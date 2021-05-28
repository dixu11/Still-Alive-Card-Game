package pl.dixu.sa.game.core;

import pl.dixu.sa.game.battle.Battle;
import pl.dixu.sa.game.battle.BattleFactory;

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
