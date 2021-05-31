package pl.dixu.sa.game.cards.factory;

import pl.dixu.sa.game.battle.Deck;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.cards.effect.BattleEffect;
import pl.dixu.sa.game.cards.effect.SpawnCharacterEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EventCardFactory {

    private CharacterCardFactory characterCardFactory;

    public EventCardFactory(CharacterCardFactory characterCardFactory) {
        this.characterCardFactory = characterCardFactory;
    }

    public Deck<EventCard> createStartingDeck() {
        Deck<EventCard> deck = new Deck<>();
        addTimes(deck, createInvest(), 2);
        addTimes(deck, createSupport(), 2);
        addTimes(deck, createAttack(), 3);
        addTimes(deck,createCharge(),1);
        addTimes(deck, createDefend(), 2);
        deck.shuffle();
        return deck;
    }

    private void addTimes(Deck<EventCard> cards, EventCard card, int count) {
        IntStream.range(0, count)
                .forEach(i -> cards.add(card));
    }

    public Deck<EventCard> createEnemyDeck() {
        Deck<EventCard> deck = new Deck<>();
        for (int i = 0; i < 6; i++) {
            deck.add(createSpawnEnemyCard());
        }
        return deck;
    }

    public EventCard createAttack() {
       return new EventCard(1, "Attack");
    }

    public EventCard createInvest() {
        return new EventCard(0, "Invest");
    }

    public EventCard createSupport() {
        return new EventCard(0, "Support");
    }

    public EventCard createCharge() {
        return new EventCard(2,  "Charge");
    }

    public EventCard createDefend() {
        return new EventCard(1, "Defend");
    }

    public EventCard createSpawnEnemyCard() {
        EventCard eventCard = new EventCard(0,  "Spawn Enemy");
        eventCard.addEffect(new SpawnCharacterEffect(characterCardFactory.createBasicEnemy(1)));
        eventCard.setEnemy(true);
        return eventCard;
    }

}
