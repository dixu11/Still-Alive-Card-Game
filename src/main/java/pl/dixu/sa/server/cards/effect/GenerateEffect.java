package pl.dixu.sa.server.cards.effect;

public abstract class GenerateEffect extends BattleEffect {

    public GenerateEffect() {
        super(EffectType.GENERATOR);
    }

    @Override
    public void execute() {
        mediator.generateEnergy(energyThisTurn());
    }

    protected abstract int energyThisTurn();


}
