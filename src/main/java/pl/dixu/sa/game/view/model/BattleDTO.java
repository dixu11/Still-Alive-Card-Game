package pl.dixu.sa.game.view.model;

import lombok.Builder;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public class BattleDTO { //don't need encapsulation for this data structure :)

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

    public List<CardAttributes> getByAreasWithEmptySlots(List<Area> possibleAreas) {
        return possibleAreas.stream()
                .flatMap(area -> {

                    List<CardAttributes> byArea = table.stream()
                            .filter(card -> card.getArea()==area)
                            .collect(Collectors.toList());
                    int emptySlots = area.getSlots() - byArea.size();
                    if (possibleAreas.contains(Area.getEmptyFor(area))) {
                        for (int i = 0; i < emptySlots; i++) {
                            byArea.add(new CardAttributes().addAttribute("name", "empty"));
                        }
                    }
                    return byArea.stream();
                })
                .collect(Collectors.toList());
    }


}
