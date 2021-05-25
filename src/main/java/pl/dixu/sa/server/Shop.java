package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.general.CharacterCard;

public class Shop {

    private Deck<CharacterCard> generators;
    private Deck<CharacterCard> defenders;

    Shop(Deck<CharacterCard> generators, Deck<CharacterCard> defenders) {
        this.generators = generators;
        this.defenders = defenders;
    }
}
