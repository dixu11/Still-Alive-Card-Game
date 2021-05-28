package pl.dixu.sa.game.battle;
import pl.dixu.sa.game.cards.general.EventCard;
import java.util.ArrayList;
import java.util.List;

public class Hand extends BattleComponent{
    private List<EventCard> cards = new ArrayList<>();

   public List<EventCard> getCards() {
        return cards;
    }

}
