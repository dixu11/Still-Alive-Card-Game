package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.cards.general.EventCard;
import java.util.List;

public class Human extends Player {
    public static final int DRAW_COUNT = 5;

    private Hand hand = new Hand();
    private Deck<EventCard> drawPile;
    private Deck<EventCard> discardPile = new Deck<>();

    private CharacterCard general;
    private int energy = 0;

    public Human(Deck<EventCard> drawPile, CharacterCard general) {
        this.drawPile = drawPile;
        this.general = general;
    }

    public void drawCards() { //todo what if deck is less than 5?
        List<EventCard> cards = drawPile.draw(DRAW_COUNT);
        int cardsLeft = DRAW_COUNT - cards.size();
        mediator.showDraw(cards);
        if (cardsLeft > 0) {
            return;
        }
        discardPile.shuffle();
        mediator.showShuffle();
        drawPile.add(discardPile);
        List<EventCard> nextCards = drawPile.draw(cardsLeft);
        cards.addAll(nextCards);
        mediator.showDraw(cards);
    }

    void playGeneral() {
        mediator.spawnCharacter(general);
    }

    public void addEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public boolean isEnemy() {
        return false;
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

}
