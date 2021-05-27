package pl.dixu.sa.server.battle;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.command.CommandClient;

import java.util.List;

public class Human extends Player {

    private int energy = 0;
    private Hand hand = new Hand();
    private Deck<EventCard> drawPile;
    private Deck<EventCard> discardPile = new Deck<>();
    private CharacterCard general;
    private CommandClient client;

    public Human(Deck<EventCard> drawPile, CharacterCard general, CommandClient client) {
        this.drawPile = drawPile;
        this.general = general;
        this.client = client;
    }

    public CharacterCard getGeneral() {
        return general;
    }

    public List<EventCard> getHand() {
        return hand.getCards();
    }

    public int discardPileSize() {
        return drawPile.size();
    }

    public int drawPileSize() {
        return discardPile.size();
    }

    void playGeneral() {
        client.spawnCharacter(general);
    }

    @Override
    public boolean isEnemy() {
        return false;
    }
}
