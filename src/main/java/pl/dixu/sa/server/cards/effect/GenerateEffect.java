package pl.dixu.sa.server.cards.effect;

import pl.dixu.sa.server.command.CommandClient;

public class GenerateEffect extends BattleEffect {

    private int energy;

    public GenerateEffect() {
        super(EffectType.GENERATOR);
    }

    @Override
    public void execute() {
        mediator.generateEnergy(energy);
    }
}
