package pl.dixu.sa.game.cards.general;

import org.w3c.dom.Attr;
import pl.dixu.sa.game.battle.BattleComponent;
import pl.dixu.sa.game.cards.effect.BattleEffect;
import pl.dixu.sa.game.cards.effect.EffectType;
import pl.dixu.sa.game.view.model.CardAttributes;

import java.util.ArrayList;
import java.util.List;

public class Card extends BattleComponent {
    private String name;

    private String dsc; //todo
    private List<BattleEffect> effects = new ArrayList<>();

    public Card() { // for lombok
        name = "";
    }

    public Card(String name) {
        this.name = name;
    }

    public void addEffect(BattleEffect effect) {
        effects.add(effect);
    }

    public void executeEffects() {
        for (BattleEffect playBattleEffect : effects) {
            playBattleEffect.execute();
        }
    }

    public void executeEffects(EffectType type) {
        effects.stream()
                .filter(e -> e.getType() == type)
                .forEach(BattleEffect::execute);
    }

    @Override
    public CardAttributes toAttributes() {
        CardAttributes attr = super.toAttributes()
                .addAttribute("name", this.name);
        effects.forEach(attr::add);
        return attr;
    }

    public String getName() {
        return name;
    }
}
