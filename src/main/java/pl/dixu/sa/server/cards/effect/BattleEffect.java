package pl.dixu.sa.server.cards.effect;

import pl.dixu.sa.server.battle.BattleComponent;

public abstract class BattleEffect extends BattleComponent {

    private EffectType type;


    BattleEffect(EffectType type) {
        this.type = type;
    }

  public abstract void execute();

   public EffectType getType() {
        return type;
    }
}
