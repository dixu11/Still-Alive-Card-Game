package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.effect.TargetableEffect;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.cards.general.EventCard;

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

    public EventCard getShopCard(int slotId) {
        return shop.getCard(slotId);
    }

    public void changeEnergy(int newEnergy) {
        human.changeEnergy(newEnergy);
    }

    public void spawnCharacter(CharacterCard character) {
        table.spawn(character);
    }

    public CharacterCard getCharacterOnTableById(int id) {
        return table.getById(id);
    }

    public void setHumanConsideredEffect(TargetableEffect targetableEffect) {
        human.setConsideredEffect(targetableEffect);
    }

    public int getDefendersLevel() {
        return table.getDefendersLevel();
    }
}
