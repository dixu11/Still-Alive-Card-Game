package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.cards.general.CharacterCard;

public class GeneratorStandardEffect extends GenerateEffect {

    private CharacterCard generator;

    public GeneratorStandardEffect(CharacterCard generator) {
        this.generator = generator;
    }

    @Override
    protected int energyThisTurn() {
        return generator.getLvl();
    }
}
