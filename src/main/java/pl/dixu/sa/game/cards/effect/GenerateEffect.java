package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.view.model.CardAttributes;

public abstract class GenerateEffect extends BattleEffect {

    public GenerateEffect() {
        super(EffectType.GENERATOR);
    }

    @Override
    public void execute() {
        mediator.generateEnergy(energyThisTurn());
    }

    protected abstract int energyThisTurn();

    @Override
    public CardAttributes toAttributes() {
       return super.toAttributes().addAttribute("generates", energyThisTurn() + "");
    }
}
