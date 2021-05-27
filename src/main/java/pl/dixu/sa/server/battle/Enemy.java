package pl.dixu.sa.server.battle;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.command.CommandClient;

public class Enemy extends Player {

    private Table table;
    private Deck<EventCard> deck;

    Enemy(Table table, Deck<EventCard> deck) {
        this.table = table;
        this.deck = deck;
    }

    public void playCard() {
        EventCard eventCard = deck.pollCard();
        mediator.playCard(eventCard,this);
    }

   public Deck<EventCard> getDeck() {
        return deck;
    }

    @Override
    public boolean isEnemy() {
        return true;
    }
}
