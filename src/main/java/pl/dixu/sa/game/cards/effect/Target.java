package pl.dixu.sa.game.cards.effect;

import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.CharacterCard;

public interface Target {

    CharacterCard toCharacter();

    Area getArea();

    boolean isEmptySlot();

}
