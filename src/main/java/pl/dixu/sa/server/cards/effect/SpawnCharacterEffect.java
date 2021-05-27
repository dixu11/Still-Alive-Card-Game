package pl.dixu.sa.server.cards.effect;

import pl.dixu.sa.server.cards.general.CharacterCard;

public class SpawnCharacterEffect extends BattleEffect {
    private CharacterCard character;

    public SpawnCharacterEffect(CharacterCard character) {
        super(EffectType.PLAY);
        this.character = character;
    }

    public void execute() {
        mediator.spawnCharacter(character);
    }
}
