package pl.dixu.sa.server.cards.general;

import pl.dixu.sa.server.Gameplay;
import pl.dixu.sa.server.cards.view.CardView;
import pl.dixu.sa.server.effect.Effect;

import java.util.List;
import java.util.Objects;

public class EventCard extends Card{

    private int cost;
    private List<Effect> playEffects;
    private boolean enemy;
    //value


    public EventCard(int cost, List<Effect> playEffects, String name) {
        super(name);
        this.cost = cost;
        this.playEffects = playEffects;
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

    public void execute(Gameplay gameplay) {
        for (Effect playEffect : playEffects) {
            playEffect.execute(gameplay);
        }
    }

    @Override
    public CardView toView() {
        return super.toView()
                .addAttribute("enemy", String.valueOf(enemy))
                .addAttribute("cost", String.valueOf(cost));
    }

   public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }
}
