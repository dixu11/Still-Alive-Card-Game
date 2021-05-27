package pl.dixu.sa.server.cards.effect;

import pl.dixu.sa.server.cards.general.CharacterCard;

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
