package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.CharacterCard;

import java.util.List;

public class AttackEffect extends TargetableEffect {

    @Override
    protected void executeOnTarget(Target target) {
        System.out.println("Atakuję postać " + target);
        int lvl = mediator.getDefendersLevel();
        target.toCharacter().receiveDmg(lvl+2);
    }

    @Override
    protected List<Area> getPossibleTargets() {
        return List.of(Area.ENEMIES);
    }
}
