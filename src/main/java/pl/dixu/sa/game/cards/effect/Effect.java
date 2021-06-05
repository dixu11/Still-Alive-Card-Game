package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.battle.BattleComponent;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.view.model.Viewable;

public abstract class Effect extends BattleComponent implements Viewable {

    private EffectType type;
    protected Card owner;

    public Effect(EffectType type) {
        this.type = type;
    }

    public abstract void execute();

    public boolean isReady() {
        return true;
    }

    public void prepare() {
        //default -> nothing to prepare
    }

    public EffectType getType() {
        return type;
    }


    public  void setOwner(Card card){
        owner = card;
    }
}
