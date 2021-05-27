package pl.dixu.sa.server.battle;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;
import java.util.List;

public class Human extends Player {

    private int energy = 0;
    private Hand hand = new Hand();
    private Deck<EventCard> drawPile;
    private Deck<EventCard> discardPile = new Deck<>();
    private CharacterCard general;

    public Human(Deck<EventCard> drawPile, CharacterCard general) {
        this.drawPile = drawPile;
        this.general = general;
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
        mediator.spawnCharacter(general);
    }

    @Override
    public boolean isEnemy() {
        return false;
    }

   public void setMediator(BattleMediator mediator) {
        this.mediator = mediator;
    }

    public void addEnergy(int energy) {
        this.energy = energy;
    }
}
