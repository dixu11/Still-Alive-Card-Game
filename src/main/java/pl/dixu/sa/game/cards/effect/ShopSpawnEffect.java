package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.CardPlayException;
import pl.dixu.sa.game.cards.general.CharacterCard;

import java.util.List;

public class ShopSpawnEffect extends TargetableEffect{

    private List<Area> possibleTargets;
    private SpawnCharacterEffect spawnEffect;

    //merge with spawn char as decorator?

    public ShopSpawnEffect(List<Area> possibleTargets, CharacterCard card) {
        this.possibleTargets = possibleTargets;
        spawnEffect = new SpawnCharacterEffect(card);
    }

    @Override
    protected void executeOnTarget(Target target) {
        if (target.isEmptySlot()) {
            spawnEffect.execute();
        } else {
            target.toCharacter().levelUp();
        }
    }

    @Override
    public void setTarget(int cardId) {
        super.setTarget(cardId);
        CharacterCard characterTarget = target.toCharacter();
        if (target.isEmptySlot()) {
            owner.growCost(2);
        } else if (characterTarget.getLvl() < 3) {
            owner.growCost(2 + characterTarget.getLvl());
        } else {
            throw new CardPlayException("Board full");
        }
    }

    @Override
    protected List<Area> getPossibleTargets() {
        return possibleTargets;
    }
}
