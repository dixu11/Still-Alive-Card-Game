package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.general.Card;

public interface Controller {

    boolean playCard(Card card);
    void buyCard();
    void upgradeCard();
    void drawCard();
    void selectTarget();
    void endTurn();

    void playGeneral();
}
