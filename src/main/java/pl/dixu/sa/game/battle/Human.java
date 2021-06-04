package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.effect.BattleEffect;
import pl.dixu.sa.game.cards.effect.TargetableEffect;
import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.view.presenter.PlayerController;

import java.util.ArrayList;
import java.util.List;

public class Human extends Player implements PlayerController {
    public static final int DRAW_COUNT = 5;

    //todo should human have reference to shop or table?
    private List<EventCard> hand = new ArrayList<>();
    private Deck<EventCard> drawPile;
    private Deck<EventCard> discardPile = new Deck<>();

    private CharacterCard general;
    private TargetableEffect consideredEffect = null;
    private int energy = 0;

    public Human(Deck<EventCard> drawPile, CharacterCard general) {
        this.drawPile = drawPile;
        this.general = general;
    }

    @Override
    public void playCard(int cardId) {
        EventCard card = Card.findCardById(hand, cardId).orElseThrow();
        int cost = card.getCost();
        if (cost > energy) {
            throw new BattleException("Not enough energy! Card costs " + cost);
        }
        mediator.changeEnergy(-cost);
        card.play(this);
        hand.remove(card);
    }

    @Override
    public void executeEffectWithTarget(int id) {
        if (consideredEffect == null) {
            return;
        }
        consideredEffect.setTarget(id);
        consideredEffect.execute();
        consideredEffect = null;
    }

    @Override
    public void buyShopCard(int slotId) {
        EventCard eventCard = mediator.buyShopCard(slotId, energy);
        int cost = eventCard.getCost();
        changeEnergy(-cost);
        hand.add(eventCard);
        client.showNewCard(eventCard);
    }

    @Override
    public void buyDraw() {
        if (energy == 0) {
            throw new BattleException("Not enough energy to draw new card!" );
        }
        changeEnergy(-1);
        drawCards(1);
    }

    @Override
    public void endTurn() {
        mediator.endTurn();
        client.showEndTurn();
    }

    public void drawCards() {
        //todo what if deck is less than 5?
        drawCards(DRAW_COUNT);
    }

    private void drawCards(int count){
        List<EventCard> cards = drawPile.draw(count);
        int cardsLeft = count - cards.size();
        hand.addAll(cards);
        client.showDraw(cards);
        if (cardsLeft == 0) return;
        discardPile.shuffle();
        client.showShuffle();
        drawPile.add(discardPile);
        List<EventCard> nextCards = drawPile.draw(cardsLeft);
        hand.addAll(nextCards);
        client.showDraw(cards);
    }

    void playGeneral() {
        mediator.spawnCharacter(general);
    }

    public void changeEnergy(int newEnergy) {
        energy += newEnergy;
        client.showEnergyChange(newEnergy);
    }

    @Override
    public boolean isEnemy() {
        return false;
    }

    public CharacterCard getGeneral() {
        return general;
    }

    public List<EventCard> getHand() {
        return new ArrayList<>(hand);
    }

    public int discardPileSize() {
        return drawPile.size();
    }

    public int drawPileSize() {
        return discardPile.size();
    }

    public int getEnergy() {
        return energy;
    }

    public void setConsideredEffect(TargetableEffect targetableEffect) {
        this.consideredEffect = targetableEffect;
    }
}
