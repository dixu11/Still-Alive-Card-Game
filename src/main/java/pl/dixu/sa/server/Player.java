package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;

public class Player {

    private int energy = 0;
    private Hand hand = new Hand();
    private Deck<EventCard> drawPile;
    private Deck<EventCard> discardPile = new Deck<>();
    private CharacterCard general;

   public Player(Deck<EventCard> drawPile, CharacterCard general) {
        this.drawPile = drawPile;
       this.general = general;
   }

  public   CharacterCard getGeneral() {
        return general;
    }
}
