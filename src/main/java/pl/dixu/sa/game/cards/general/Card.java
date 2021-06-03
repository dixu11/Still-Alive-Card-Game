package pl.dixu.sa.game.cards.general;

import pl.dixu.sa.game.battle.BattleComponent;
import pl.dixu.sa.game.cards.effect.BattleEffect;
import pl.dixu.sa.game.cards.effect.EffectType;
import pl.dixu.sa.game.view.model.CardAttributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Card extends BattleComponent {
    private int id;
    protected String name;
    private String dsc; //todo
    private List<BattleEffect> effects = new ArrayList<>();
    private CharacterCard target = null;
    private static int nextId = 1;

    { // initialization block triggers before all constructors
        id = nextId++;
    }

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

    public void assignTargetAndTrigger(CharacterCard card) {
        target = card;
        executeEffects();
    }

    @Override
    public CardAttributes toAttributes() {
        CardAttributes attr = super.toAttributes()
                .addAttribute("id", id + "")
                .addAttribute("name", name);
        effects.forEach(attr::add);
        return attr;
    }

    public int getId() {
        return id;
    }

    public  static <T extends Card> Optional<T> findCardById(Collection<T> cards, int id) {
        return cards.stream()
                .filter(c -> c.getId() == id)
                .findAny();
    }

    public String getName() {
        return name;
    }
}
