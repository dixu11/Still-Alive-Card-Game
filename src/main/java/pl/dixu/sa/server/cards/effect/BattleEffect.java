package pl.dixu.sa.server.cards.effect;

import pl.dixu.sa.server.battle.BattleComponent;
import pl.dixu.sa.server.view.Viewable;

import java.util.List;

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
