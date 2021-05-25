package pl.dixu.sa.server.cards.factory;

import pl.dixu.sa.server.Deck;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.effect.Effect;
import pl.dixu.sa.server.effect.SpawnCharacter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventCardFactory {

    private CharacterCardFactory characterCardFactory;

    public EventCardFactory(CharacterCardFactory characterCardFactory) {
        this.characterCardFactory = characterCardFactory;
    }

    public Deck<EventCard> createStartingDeck() {
        Deck<EventCard> deck = new Deck<>();
        deck.add(createAttack());
        deck.add(createAttack());
        deck.add(createAttack());
        deck.add(createAttack());
        deck.add(createInvest());
        deck.add(createInvest());
        deck.add(createSupport());
        deck.add(createSupport());
        deck.add(createDefend());
        deck.add(createDefend());
        deck.add(createCharge());
        return deck;
    }

    public Deck<EventCard> createEnemyDeck() {
        Deck<EventCard> deck = new Deck<>();
        for (int i = 0; i < 6; i++) {
            deck.add(createSpawnEnemyCard());
        }
        return deck;
    }

    public EventCard createAttack() {
        List<Effect> effects = new ArrayList<>();
        return new EventCard(1,effects, "Attack");
    }

    public EventCard createInvest() {
        List<Effect> effects = new ArrayList<>();
        return new EventCard(0,effects, "Invest");
    }

    public EventCard createSupport() {
        List<Effect> effects = new ArrayList<>();
        return new EventCard(0,effects,"Support");
    }

    public EventCard createCharge() {
        List<Effect> effects = new ArrayList<>();
        return new EventCard(2,effects, "Charge");
    }

    public EventCard createDefend() {
        List<Effect> effects = new ArrayList<>();
        return new EventCard(1,effects,"Defend");
    }

    public EventCard createSpawnEnemyCard() {
        List<Effect> effects = new ArrayList<>();
        effects.add(new SpawnCharacter(characterCardFactory.createBasicEnemy(1)));
        EventCard eventCard = new EventCard(0, effects, "Spawn Enemy");
        eventCard.setEnemy(true);
        return eventCard;
    }



}
