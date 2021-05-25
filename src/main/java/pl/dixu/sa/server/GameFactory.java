package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.factory.CharacterCardFactory;
import pl.dixu.sa.server.cards.factory.EventCardFactory;

public class GameFactory {

    private CharacterCardFactory characterCardFactory = new CharacterCardFactory();
    private EventCardFactory eventCardFactory = new EventCardFactory(characterCardFactory);


    public Game createCoreGame() {
        Player player = new Player(eventCardFactory.createStartingDeck(), characterCardFactory.createGeneral());
        Shop shop = new Shop(characterCardFactory.createStartingGenerators(),characterCardFactory.createStartingDefenders());
        Table table = new Table();
        return new Game(shop, player, table, eventCardFactory.createEnemyDeck());
    }

}
