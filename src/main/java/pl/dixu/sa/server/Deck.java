package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.general.Card;

import java.util.LinkedList;
import java.util.Queue;

public class Deck<T extends Card> {

    private Queue<T> cards = new LinkedList<>();

    public Deck(Queue<T> cards) {
        this.cards = cards;
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
}
