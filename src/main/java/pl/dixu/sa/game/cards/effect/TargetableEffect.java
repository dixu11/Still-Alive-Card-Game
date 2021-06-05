package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.cards.general.Area;

import java.util.List;

//decorator
public abstract class TargetableEffect extends Effect {

    protected Target target;

    public TargetableEffect() {
        super(EffectType.PLAY);
    }

    @Override
    public void execute() {
        executeOnTarget(target);
    }

    @Override
    public void prepare() {
        if (target != null) {
            return;
        }
        mediator.setHumanConsideredEffect(this);
        client.chooseTarget(this, getPossibleTargets());
    }

    protected abstract void executeOnTarget(Target target);

    protected abstract List<Area> getPossibleTargets();

    public void setTarget(int cardId) {
        target = mediator.getCharacterOnTableById(cardId);
    }

    @Override
    public boolean isReady() {
        return target != null;
    }
}
