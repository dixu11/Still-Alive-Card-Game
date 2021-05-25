package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;

public class Game {

    private Shop shop;
    private Player player;
    private Table table;
    private Deck<EventCard> enemyDeck;

    Game(Shop shop, Player player, Table table, Deck<EventCard> enemyDeck) {
        this.shop = shop;
        this.player = player;
        this.table = table;
        this.enemyDeck = enemyDeck;
    }

   public CharacterCard playGeneral() {
       CharacterCard general = player.getGeneral();
       spawnCharacter(general);
       return general;
   }

    EventCard drawEnemyEvent() {
        return enemyDeck.pollCard();
    }

    void spawnCharacter(CharacterCard character) {
        table.playCard(character);
    }
}
