package pl.dixu.sa.server.cards.effect;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.command.CommandClient;

public class SpawnCharacter implements BattleEffect {
    private CharacterCard character;

    public SpawnCharacter(CharacterCard character) {
        this.character = character;
    }

    public void execute(CommandClient client) {
        client.spawnCharacter(character);
    }
}
