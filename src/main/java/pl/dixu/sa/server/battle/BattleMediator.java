package pl.dixu.sa.server.battle;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;

public class BattleMediator {

    private Battle battle;
    private Shop shop;
    private Player player;
    private Table table;
    private Deck<EventCard> enemyDeck;


   public BattleMediator(Battle battle, Shop shop, Player player, Table table, Deck<EventCard> enemyDeck) {
       this.battle = battle;
       this.shop = shop;
        this.player = player;
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
