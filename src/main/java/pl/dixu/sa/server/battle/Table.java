package pl.dixu.sa.server.battle;

import pl.dixu.sa.server.cards.general.Area;
import pl.dixu.sa.server.cards.general.CharacterCard;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Table {

    private List<CharacterCard> playedCards = new LinkedList<>();

    //todo to remove
    void playCard(CharacterCard card) {
        playedCards.add(card);
    }

   public List<CharacterCard> getByArea(Area area){
      return   playedCards.stream()
                .filter(c->c.getArea() == area)
                .collect(Collectors.toList());
    }

   public void spawn(CharacterCard character) {
        playedCards.add(character);
    }
}
