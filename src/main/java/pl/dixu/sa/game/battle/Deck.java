package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.EventCard;

import java.util.*;
import java.util.stream.Collectors;

public class Deck<T extends Card> extends BattleComponent{

    private LinkedList<T> cards = new LinkedList<>();

    public Deck(Collection<T> cards) {
        this.cards.addAll(cards);
    }

    public Deck() {
    }

    public void add(T card) {
        cards.add(card);
    }

    //fixme nullpointer!
    T pollCard() {
        return cards.poll();
    }

    T peekFirst() {
        return cards.peek();
    }

    int size() {
        return cards.size();
    }

    public List<T> draw(int drawCount) {
        return cards.stream()
                .limit(drawCount)
                .collect(Collectors.toList());
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void add(Deck<T> deck) {
        cards.addAll(deck.cards);
    }
}
