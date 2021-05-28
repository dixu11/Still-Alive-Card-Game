package pl.dixu.sa.game.battle;
import pl.dixu.sa.game.cards.general.EventCard;

public class Enemy extends Player {

    private Table table;
    private Deck<EventCard> deck;

    Enemy(Table table, Deck<EventCard> deck) {
        this.table = table;
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
