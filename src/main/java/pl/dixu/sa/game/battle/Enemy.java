package pl.dixu.sa.game.battle;
import pl.dixu.sa.game.cards.general.EventCard;

public class Enemy extends Player {

    private Deck<EventCard> deck;

   public Enemy( Deck<EventCard> deck) {
        this.deck = deck;
    }

    public void playCard() {
        EventCard eventCard = deck.pollCard();
        mediator.playCard(this,eventCard);
    }

   public Deck<EventCard> getDeck() {
        return deck;
    }

    @Override
    public boolean isEnemy() {
        return true;
    }
}
