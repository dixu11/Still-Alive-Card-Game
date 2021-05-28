package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.view.CommandClient;

public class BattleFactory {
    private CommandClient client;

    public BattleFactory(CommandClient client) {
        this.client = client;
    }

   public Battle createBattle() {
       return new Battle(client);
    }
}
