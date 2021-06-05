package pl.dixu.sa.game.cards.general;

import pl.dixu.sa.game.battle.BattleComponent;
import pl.dixu.sa.game.cards.effect.Effect;
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
    protected List<Effect> effects = new ArrayList<>();
    private CharacterCard target = null;
    protected int cost;
    private static int nextId = 1;

    { // initialization block triggers before all constructors
        id = nextId++;
    }

    public Card() { // for lombok
        this("",-1);
    }

    public Card(String name) {
        this(name, -1);
    }

    public Card(int cost){
        this("",cost);
    }

    public Card(String name,int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void addEffect(Effect effect) {
        effects.add(effect);
        effect.setOwner(this);
    }

    public void executeEffects() {
        for (Effect playEffect : effects) {
            playEffect.execute();
        }
    }

    public void executeEffects(EffectType type) {
        effects.stream()
                .filter(e -> e.getType() == type)
                .forEach(Effect::execute);
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

    public void growCost(int cost) {
        this.cost += cost;
    }
}
