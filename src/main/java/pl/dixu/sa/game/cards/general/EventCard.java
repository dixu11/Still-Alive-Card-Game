package pl.dixu.sa.game.cards.general;

import pl.dixu.sa.game.view.model.CardAttributes;
import java.util.Objects;

public class EventCard extends Card{

    private int cost;
    private boolean enemy;
    //value

    public EventCard(int cost,  String name) {
        super(name);
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventCard eventCard = (EventCard) o;
        return cost == eventCard.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost);
    }

    @Override
    public CardAttributes toAttributes() {
        return super.toAttributes()
                .addAttribute("enemy", String.valueOf(enemy))
                .addAttribute("cost", String.valueOf(cost))
                .addAttribute("event", "true");
    }

   public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }
}
