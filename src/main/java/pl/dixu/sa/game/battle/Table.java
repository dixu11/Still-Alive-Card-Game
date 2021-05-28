package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.effect.EffectType;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.view.CommandClient;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Table extends BattleComponent{

    private List<CharacterCard> playedCards = new LinkedList<>();
    private CommandClient client;

    public Table(CommandClient client) {
        this.client = client;
    }

   public List<CharacterCard> getByArea(Area area){
      return   playedCards.stream()
                .filter(c->c.getArea() == area)
                .collect(Collectors.toList());
    }

   public void spawn(CharacterCard character) {
        playedCards.add(character);
    }

    public void triggerGenerators() {
        executeEffectsByCategory(EffectType.GENERATOR);
    }

    public void executeEffectsByCategory(EffectType type) {
        playedCards.stream()
                .forEach(c -> c.executeEffect(type));
    }
}
