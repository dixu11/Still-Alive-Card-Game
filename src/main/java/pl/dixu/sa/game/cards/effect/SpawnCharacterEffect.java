package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.cards.general.CharacterCard;

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
