package pl.dixu.sa.server;
import pl.dixu.sa.server.cards.general.EventCard;
import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<EventCard> cards = new ArrayList<>();

   public List<EventCard> getCards() {
        return cards;
    }

}
