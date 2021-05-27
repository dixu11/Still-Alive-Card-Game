package pl.dixu.sa.server.command;

import pl.dixu.sa.server.battle.BattleMediator;
import pl.dixu.sa.server.engine.Engine;
import pl.dixu.sa.server.cards.general.CharacterCard;

//2 roles - assembly command and execute them
public class CommandClient {

    private BattleCommandFactory factory;
    private Engine engine;

    public CommandClient(BattleCommandFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public void spawnCharacter(CharacterCard card) {
        SpawnEventCommand command = factory.getSpawnCharacterCommand();
        command.prepare(card);
        engine.execute(command);
    }

   public void setMediator(BattleMediator mediator) {
       factory.setMediator(mediator);
    }

    public void startBattle() {
        StartBattleCommand command = factory.getStartBattleCommand();
        engine.execute(command);
    }
}
