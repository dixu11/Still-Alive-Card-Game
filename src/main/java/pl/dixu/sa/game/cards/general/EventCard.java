package pl.dixu.sa.game.cards.general;

import pl.dixu.sa.game.battle.Player;
import pl.dixu.sa.game.view.model.CardAttributes;
import java.util.Objects;

public class EventCard extends Card{

    private int cost;
    private boolean enemy;
    //value //todo next reason to introduce EnemyEventCard class?

    public EventCard(int cost,  String name) {
        super(name);
        this.cost = cost;
    }

    public void play(Player owner) {
        client.showCardPlayed(owner,this);
        executeEffects();
    }

    public void setEnemy(boolean enemy) {
        this.enemy = enemy;
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

    public int getCost() {
        return cost;
    }
}
