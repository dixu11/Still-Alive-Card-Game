package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.general.CharacterCard;

import java.util.LinkedList;
import java.util.List;

public class Table {

    private List<CharacterCard> playedCards = new LinkedList<>();

    void playCard(CharacterCard card) {
        playedCards.add(card);
    }
}
