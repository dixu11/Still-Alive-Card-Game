package pl.dixu.sa.server.effect;

import pl.dixu.sa.server.Gameplay;
import pl.dixu.sa.server.cards.general.CharacterCard;

public class SpawnCharacter implements Effect {
    private CharacterCard character;

    public SpawnCharacter(CharacterCard character) {
        this.character = character;
    }

    @Override
    public void execute(Gameplay gameplay) {
        gameplay.spawnCharacter(character);
    }
}
