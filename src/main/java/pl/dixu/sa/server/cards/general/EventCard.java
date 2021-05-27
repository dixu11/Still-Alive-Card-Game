package pl.dixu.sa.server.cards.general;

import pl.dixu.sa.server.view.CardView;
import pl.dixu.sa.server.command.CommandClient;
import pl.dixu.sa.server.cards.effect.BattleEffect;

import java.util.List;
import java.util.Objects;

public class EventCard extends Card{

    private int cost;
    private List<BattleEffect> playBattleEffects;
    private boolean enemy;
    //value

    public EventCard(int cost, List<BattleEffect> playBattleEffects, String name) {
        super(name);
        this.cost = cost;
        this.playBattleEffects = playBattleEffects;
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

    public void execute() {
        for (BattleEffect playBattleEffect : playBattleEffects) {
            playBattleEffect.execute();
        }
    }

    @Override
    public CardView toView() {
        return super.toView()
                .addAttribute("enemy", String.valueOf(enemy))
                .addAttribute("cost", String.valueOf(cost))
                .addAttribute("event", "true");
    }

   public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }
}
