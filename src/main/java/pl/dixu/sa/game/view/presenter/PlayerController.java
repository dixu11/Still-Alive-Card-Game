package pl.dixu.sa.game.view.presenter;

public interface PlayerController {

    void playCard(int cardId);

    void buyShopCard(int slotId);

    void buyDraw();

    void endTurn();

    void assignTarget(int cardId);
}
