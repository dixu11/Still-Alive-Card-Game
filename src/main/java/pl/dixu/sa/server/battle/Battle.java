package pl.dixu.sa.server.battle;

import pl.dixu.sa.server.cards.factory.CharacterCardFactory;
import pl.dixu.sa.server.cards.factory.EventCardFactory;
import pl.dixu.sa.server.cards.general.Area;
import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.view.CardView;
import pl.dixu.sa.server.view.BattleDTO;
import pl.dixu.sa.server.command.CommandClient;

import java.util.List;
import java.util.stream.Collectors;

public class Battle {

    //todo remove
    private Shop shop;
    private Human human;
    private Table table;
    private Enemy enemy;
    private CommandClient client;
    private BattleMediator battleMediator;

    public Battle(CommandClient client) {
        this.client = client;
        CharacterCardFactory characterCardFactory = new CharacterCardFactory();
        EventCardFactory eventCardFactory = new EventCardFactory(characterCardFactory);
        Deck<EventCard> enemyDeck = eventCardFactory.createEnemyDeck();
        enemy = new Enemy(table, enemyDeck, client);
        human = new Human(eventCardFactory.createStartingDeck(), characterCardFactory.createGeneral(), client);
        shop = new Shop(characterCardFactory.createStartingGenerators(), characterCardFactory.createStartingDefenders());
        table = new Table();
        battleMediator = new BattleMediator(this, shop, human, table, enemyDeck);
        client.setMediator(battleMediator);
    }

    public void start() {
        client.startBattle();
        human.playGeneral();
        enemy.playCard();
    }

   public BattleDTO toDTO() {
        return BattleDTO.builder()
                .shopCard1(shop.peekFirstGenerator().toView())
                .shopCard2(shop.peekFirstDefender().toView())
                .hand(toViews2(human.getHand()))
                .discardPile(human.discardPileSize())
                .drawPile(human.drawPileSize())
                .general(human.getGeneral().toView())
                .defenders(toViews(table.getByArea(Area.DEFENDERS)))
                .generators(toViews(table.getByArea(Area.GENERATORS)))
                .enemies(toViews(table.getByArea(Area.ENEMIES)))
                .enemyDraw(enemy.getDeck().peekFirst().toView())
                .build();
    }
    //todo pora na powtórkę z generyków!

    List<CardView> toViews(List<CharacterCard> cards) {
        return cards.stream()
                .map(c -> c.toView())
                .collect(Collectors.toList());
    }

    List<CardView> toViews2(List<EventCard> cards) {
        return cards.stream()
                .map(c -> c.toView())
                .collect(Collectors.toList());
    }
}

