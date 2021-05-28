package pl.dixu.sa.game.cards.factory;

import pl.dixu.sa.game.battle.Deck;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.cards.effect.BattleEffect;
import pl.dixu.sa.game.cards.effect.SpawnCharacterEffect;

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
        return new EventCard(1,  "Attack");
    }

    public EventCard createInvest() {
        List<BattleEffect> battleEffects = new ArrayList<>();
        return new EventCard(0,  "Invest");
    }

    public EventCard createSupport() {
        List<BattleEffect> battleEffects = new ArrayList<>();
        return new EventCard(0, "Support");
    }

    public EventCard createCharge() {
        List<BattleEffect> battleEffects = new ArrayList<>();
        return new EventCard(2,  "Charge");
    }

    public EventCard createDefend() {
        List<BattleEffect> battleEffects = new ArrayList<>();
        return new EventCard(1, "Defend");
    }

    public EventCard createSpawnEnemyCard() {
        EventCard eventCard = new EventCard(0,  "Spawn Enemy");
        eventCard.addEffect(new SpawnCharacterEffect(characterCardFactory.createBasicEnemy(1)));
        eventCard.setEnemy(true);
        return eventCard;
    }

}
