package pl.dixu.sa.game.cards.general;

import pl.dixu.sa.game.battle.BattleComponent;
import pl.dixu.sa.game.cards.effect.BattleEffect;
import pl.dixu.sa.game.cards.effect.EffectType;
import pl.dixu.sa.game.view.model.CardAttributes;

import java.util.ArrayList;
import java.util.List;

public class Card extends BattleComponent  {

    private String name;
    private String dsc; //todo
    private List<BattleEffect> effects = new ArrayList<>();

   public Card() { // for lombok
       name = "";
    }

    public void addEffect(BattleEffect effect) {
        effects.add(effect);
    }

    public Card(String name) {
        this.name = name;
    }

   public String getName() {
       return name;
    }

    @Override
    public CardAttributes toAttributes() {
        CardAttributes attr = super.toAttributes()
                .addAttribute("name", this.name);
        effects.forEach(e -> attr.add(e));
        return attr;
    }

    public void executeEffect(EffectType type) {
        effects.stream()
                .filter(e -> e.getType() == type)
                .forEach(e-> e.execute());
    }

    public void executeEffect() {
        for (BattleEffect playBattleEffect : effects) {
            playBattleEffect.execute();
        }
    }
}
