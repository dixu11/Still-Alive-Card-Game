package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.cards.general.EventCard;

public class Shop extends BattleComponent{

    private Deck<CharacterCard> generators;
    private Deck<CharacterCard> defenders;

    Shop(Deck<CharacterCard> generators, Deck<CharacterCard> defenders) {
        this.generators = generators;
        this.defenders = defenders;
    }

    public CharacterCard peekFirstGenerator() {
        return generators.peekFirst();
    }

    public CharacterCard peekFirstDefender() {
        return defenders.peekFirst();
    }

    public EventCard buyCard(int cardId, int energy) {
        Deck<CharacterCard> correctDeck;
        CharacterCard shopCard;
        if (generators.peekFirst().getId() == cardId) {
            correctDeck = generators;
        } else if (defenders.peekFirst().getId() == cardId) {
            correctDeck = defenders;
        } else {
            throw new IllegalStateException("Presenter asks about not existing card id: " + cardId);
        }
        shopCard = correctDeck.peekFirst();
        EventCard eventCard = shopCard.toEventCard();
        if (eventCard.getCost() > energy) {
            throw new BattleException("You have not enough energy to buy: " + shopCard.getName());
        }
        correctDeck.pollCard();
        return eventCard;
    }
}

//todo refactor - slots
