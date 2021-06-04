package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.CharacterCard;

import java.util.List;

//decorator
public abstract class TargetableEffect extends BattleEffect{

    private CharacterCard target;

    public TargetableEffect() {
        super(EffectType.PLAY);
    }

    @Override
    public void execute() {
        if (target == null) {
            mediator.setHumanConsideredEffect(this);
            client.chooseTarget(this,getPossibleTargets());
        } else {
            executeOnTarget(target);
        }
    }

    protected abstract void executeOnTarget(CharacterCard target);

    protected abstract List<Area> getPossibleTargets();

   public void setTarget(int cardId){
      target = mediator.getCharacterOnTableById(cardId);
   }
}
