package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.view.CommandClient;

import java.util.List;

public class BattleMediator {

    private Battle battle;
    private Shop shop;
    private Human human;
    private Table table;
    private Enemy enemy;

    public BattleMediator() {
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
        this.shop = battle.getShop();
        this.human = battle.getHuman();
        this.table = battle.getTable();
        this.enemy = battle.getEnemy();
    }

    public int getTurnNumber() {
        return battle.getTurnNr();
    }

    public void endTurn() {
        battle.endTurn();
    }

    public EventCard buyShopCard(int slotId, int energy) {
        return shop.buyCard(slotId, energy);
    }

    public void assignTargetForActiveCard(int cardId) {
        table.assignTargetForActiveCard(cardId);
    }

    public void changeEnergy(int newEnergy) {
        human.changeEnergy(newEnergy);
    }

    public void spawnCharacter(CharacterCard character) {
        table.spawn(character);
    }
}
