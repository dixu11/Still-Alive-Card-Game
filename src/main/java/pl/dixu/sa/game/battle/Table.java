package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.effect.EffectType;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.CharacterCard;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Table extends BattleComponent{

    private List<CharacterCard> cards = new LinkedList<>();

    public void triggerGenerators() {
        executeEffectsByCategory(EffectType.GENERATOR);
    }

    public void executeEffectsByCategory(EffectType type) {
        cards.forEach(c -> c.executeEffects(type));
    }

    public void spawn(CharacterCard character) {
        cards.add(character);
        client.showSpawnCharacter(character);
    }

   public List<CharacterCard> getByArea(Area area){
      return   cards.stream()
                .filter(c->c.getArea() == area)
                .collect(Collectors.toList());
    }

    public List<CharacterCard> getCards() {
        return cards;
    }

    public CharacterCard getById(int id) {
        return cards.stream()
                .filter(card -> card.getId() == id)
                .findAny()
                .orElseThrow();
    }

    public int getDefendersLevel() {
        return getByArea(Area.DEFENDERS)
                .stream()
                .mapToInt( CharacterCard::getLvl)
                .sum();
    }
}
