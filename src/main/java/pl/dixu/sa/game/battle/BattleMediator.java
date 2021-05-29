package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.general.Card;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.view.CommandClient;

import java.util.List;

public class BattleMediator {

    private CommandClient client;

    private Battle battle;
    private Shop shop;
    private Human human;
    private Table table;
    private Enemy enemy;

    public BattleMediator(Battle battle,CommandClient client) {
        this.battle = battle;
        this.shop =battle.getShop();
        this.human = battle.getHuman();
        this.table = battle.getTable();
        this.enemy = battle.getEnemy();
        this.client = client;
    }

    //pure logic
    public int getTurnNumber() {
        return battle.getTurnNr();
    }

    //logic and presentation
    public void spawnCharacter(CharacterCard character) {
        table.spawn(character);
        client.spawnCharacter(character);
    }

    public void playCard( Enemy enemy,EventCard eventCard) {
        eventCard.executeEffect();
        client.playCard(enemy, eventCard);
    }

    public void generateEnergy(int energy) {
        human.addEnergy(energy);
        client.addEnergy(energy);
    }

    //pure presentation
    public void showDraw(List<? extends Card> cards) {
        client.showDraw(cards);
    }
    public void startBattle() {
        client.startBattle(battle);
    }

    public void showShuffle() {
        client.showShuffle();
    }
}
