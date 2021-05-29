package pl.dixu.sa.game.core;

import pl.dixu.sa.game.battle.Battle;
import pl.dixu.sa.game.view.CommandClient;

//global game service (all game stages, even outside battles)
public class Gameplay {

    private CommandClient client;

    public Gameplay(CommandClient client) {
        this.client = client;
    }
    public void startGame() {
        startGameplay();
    }

    private void startGameplay() {
        startBattle();
    }

    private void startBattle() {
        Battle battle = new Battle(client);
        battle.begin();
    }
}
