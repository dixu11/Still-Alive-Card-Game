package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.general.Card;

import java.util.*;
import java.util.stream.Collectors;

public class Deck<T extends Card> extends BattleComponent{

    private LinkedList<T> cards = new LinkedList<>();

    public Deck(Collection<T> cards) {
        super();
        this.cards.addAll(cards);
    }

    public Deck() {
        super();
    }

    public List<T> draw(int drawCount) {
        return cards.stream()
                .limit(drawCount)
                .collect(Collectors.toList());
    }

    public void add(Deck<T> deck) {
        cards.addAll(deck.cards);
    }

    public void add(T card) {
        cards.add(card);
    }

    T pollCard() {//fixme nullpointer!
        return cards.poll();
    }

    T peekFirst() {
        return cards.peek();
    }

    int size() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
