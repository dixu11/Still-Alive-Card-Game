package pl.dixu.sa.game.view.presenter;

public interface PlayerController {

    void playCard(int cardId);

    void buyShopCard(int slotId); //todo replace by playCard

    void buyDraw();

    void endTurn();

    void executeEffectWithTarget(int id);
}
