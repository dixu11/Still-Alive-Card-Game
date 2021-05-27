package pl.dixu.sa.server.battle;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.command.CommandClient;

public class BattleMediator {

    private Battle battle;
    private Shop shop;
    private Human human;
    private Table table;
    private Enemy enemy;
    private CommandClient client;


    public BattleMediator(Battle battle,CommandClient client) {
        this.battle = battle;
        this.shop =battle.getShop();
        this.human = battle.getHuman();
        this.table = battle.getTable();
        this.enemy = battle.getEnemy();
        this.client = client;
    }

    public void spawn(CharacterCard character) {
        table.spawn(character);
    }

    public Battle getBattle() {
        return battle;
    }

    public void startBattle() {
        client.startBattle(battle);
    }

    public void spawnCharacter(CharacterCard character) {
        table.spawn(character);
        client.spawnCharacter(character);
    }

    public void playCard(EventCard eventCard, Enemy enemy) {
        eventCard.execute();
        client.playCard(eventCard, enemy);
    }

    public void generateEnergy(int energy) {
        //todo
    }
}
