package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.effect.EffectType;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.cards.general.EventCard;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Table extends BattleComponent{

    private List<CharacterCard> playedCards = new LinkedList<>();
    private EventCard activeCard = null;

    public void assignTargetForActiveCard(int cardId) {
        if (activeCard == null) {
            throw new IllegalStateException("There is no active card! Why presenter wants to set target to: " + cardId + "?");
        }
        CharacterCard card = Card.findCardById(playedCards, cardId).orElseThrow();
        activeCard.assignTargetAndTrigger(card);
        activeCard = null;
    }

    public void triggerGenerators() {
        executeEffectsByCategory(EffectType.GENERATOR);
    }

    public void executeEffectsByCategory(EffectType type) {
        playedCards.forEach(c -> c.executeEffects(type));
    }

    public void spawn(CharacterCard character) {
        playedCards.add(character);
        client.showSpawnCharacter(character);
    }

   public List<CharacterCard> getByArea(Area area){
      return   playedCards.stream()
                .filter(c->c.getArea() == area)
                .collect(Collectors.toList());
    }

    public List<CharacterCard> getCards() {
        return playedCards;
    }
}
