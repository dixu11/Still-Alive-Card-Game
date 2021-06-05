package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.cards.general.EventCard;

public class Shop extends BattleComponent {

    private Deck<EventCard> generators;
    private Deck<EventCard> defenders;

   public Shop(Deck<EventCard> generators, Deck<EventCard> defenders) {
        super();
        this.generators = generators;
        this.defenders = defenders;
    }

    public EventCard peekFirstGenerator() {
        return generators.peekFirst();
    }

    public EventCard peekFirstDefender() {
        return defenders.peekFirst();
    }

    public EventCard getCard(int slotId) {
        Deck<EventCard> correctDeck;
        EventCard shopCard;
        if (slotId == 0) {
            correctDeck = generators;
        } else if (slotId == 1) {
            correctDeck = defenders;
        } else {
            throw new IllegalStateException("Presenter asks about not existing slot id: " + slotId);
        }
        shopCard = correctDeck.peekFirst();
        return shopCard;
    }
}
