package pl.dixu.sa.server.cards.view;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
public  class GameDTO { //don't need encapsulation for this data structure :)

    public final CardView shopCard1;
    public final CardView shopCard2;
    public final List<CardView> generators;
    public final CardView general;
    public final List<CardView> defenders;
    public final List<CardView> enemies;
    public final int discardPile;
    public final List<CardView> hand;
    public final int drawPile;
    public final CardView enemyDraw;

}
