package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.battle.BattleComponent;
import pl.dixu.sa.game.view.model.Viewable;

public abstract class BattleEffect extends BattleComponent implements Viewable {

    private EffectType type;

    public BattleEffect(EffectType type) {
        this.type = type;
    }

    public abstract void execute();

    public EffectType getType() {
        return type;
    }


}
