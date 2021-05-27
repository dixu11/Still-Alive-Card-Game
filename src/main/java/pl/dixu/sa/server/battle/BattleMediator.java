package pl.dixu.sa.server.battle;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;

public class BattleMediator {

    private Battle battle;
    private Shop shop;
    private Human human;
    private Table table;
    private Deck<EventCard> enemyDeck;


   public BattleMediator(Battle battle, Shop shop, Human human, Table table, Deck<EventCard> enemyDeck) {
       this.battle = battle;
       this.shop = shop;
        this.human = human;
        this.table = table;
        this.enemyDeck = enemyDeck;
    }

    public void spawn(CharacterCard character) {
        table.spawn(character);
    }

    public Battle getBattle() {
        return battle;
    }
}
