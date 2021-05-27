package pl.dixu.sa.server.view;

import lombok.Builder;

import java.util.List;

@Builder
public  class BattleDTO { //don't need encapsulation for this data structure :)

    public final CardAttributes shopCard1;
    public final CardAttributes shopCard2;
    public final List<CardAttributes> generators;
    public final CardAttributes general;
    public final List<CardAttributes> defenders;
    public final List<CardAttributes> enemies;
    public final int discardPile;
    public final List<CardAttributes> hand;
    public final int drawPile;
    public final CardAttributes enemyDraw;

}
