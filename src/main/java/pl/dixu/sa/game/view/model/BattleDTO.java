package pl.dixu.sa.game.view.model;

import lombok.Builder;
import pl.dixu.sa.game.cards.general.Area;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public  class BattleDTO { //don't need encapsulation for this data structure :)

    public final CardAttributes shopCard1;
    public final CardAttributes shopCard2;
//    public final List<CardAttributes> generators;
//    public final CardAttributes general;
//    public final List<CardAttributes> defenders;
//    public final List<CardAttributes> enemies;
   public final List<CardAttributes> table; // as table to simplify
    public final int discardPile;
    public final List<CardAttributes> hand;
    public final int drawPile;
    public final CardAttributes enemyDraw;
    public final int energy;

    public List<CardAttributes> getByAreas(List<Area> possibleAreas) {
        return table.stream()
                .filter(card -> possibleAreas.contains(card.getArea()))
                .collect(Collectors.toList());
    }

}
