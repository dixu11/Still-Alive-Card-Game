package pl.dixu.sa.game.cards.factory;

import pl.dixu.sa.game.battle.Deck;
import pl.dixu.sa.game.cards.effect.AttackEffect;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.cards.effect.SpawnCharacterEffect;

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
        EventCard eventCard = new EventCard("Attack",1);
        eventCard.addEffect(new AttackEffect());
        return eventCard;
    }

    public EventCard createInvest() {
        return new EventCard( "Invest",0);
    }

    public EventCard createSupport() {
        return new EventCard( "Support",0);
    }

    public EventCard createCharge() {
        return new EventCard("Charge",2);
    }

    public EventCard createDefend() {
        return new EventCard( "Defend",1);
    }

    public EventCard createSpawnEnemyCard() {
        EventCard eventCard = new EventCard(  "Spawn Enemy",0);
        eventCard.addEffect(new SpawnCharacterEffect(characterCardFactory.createBasicEnemy(1)));
        eventCard.setEnemy(true);
        return eventCard;
    }

}
