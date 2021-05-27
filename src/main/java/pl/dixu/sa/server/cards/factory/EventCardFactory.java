package pl.dixu.sa.server.cards.factory;

import pl.dixu.sa.server.battle.Deck;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.cards.effect.BattleEffect;
import pl.dixu.sa.server.cards.effect.SpawnCharacterEffect;

import java.util.ArrayList;
import java.util.List;

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
        List<BattleEffect> battleEffects = new ArrayList<>();
        return new EventCard(1, battleEffects, "Attack");
    }

    public EventCard createInvest() {
        List<BattleEffect> battleEffects = new ArrayList<>();
        return new EventCard(0, battleEffects, "Invest");
    }

    public EventCard createSupport() {
        List<BattleEffect> battleEffects = new ArrayList<>();
        return new EventCard(0, battleEffects,"Support");
    }

    public EventCard createCharge() {
        List<BattleEffect> battleEffects = new ArrayList<>();
        return new EventCard(2, battleEffects, "Charge");
    }

    public EventCard createDefend() {
        List<BattleEffect> battleEffects = new ArrayList<>();
        return new EventCard(1, battleEffects,"Defend");
    }

    public EventCard createSpawnEnemyCard() {
        List<BattleEffect> battleEffects = new ArrayList<>();
        battleEffects.add(new SpawnCharacterEffect(characterCardFactory.createBasicEnemy(1)));
        EventCard eventCard = new EventCard(0, battleEffects, "Spawn Enemy");
        eventCard.setEnemy(true);
        return eventCard;
    }

}
