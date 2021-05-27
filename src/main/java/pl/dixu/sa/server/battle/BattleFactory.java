package pl.dixu.sa.server.battle;

import pl.dixu.sa.server.command.CommandClient;

public class BattleFactory {
    private CommandClient client;

    public BattleFactory(CommandClient client) {
        this.client = client;
    }

   public Battle createBattle() {
       return new Battle(client);
    }
}
