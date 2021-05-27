package pl.dixu.sa.server.battle;

import pl.dixu.sa.server.cards.factory.CharacterCardFactory;
import pl.dixu.sa.server.cards.factory.EventCardFactory;
import pl.dixu.sa.server.cards.general.Area;
import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.view.CardAttributes;
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
    private BattleMediator battleMediator;
    private int turn = 1;

    public Battle(CommandClient client) {
        CharacterCardFactory characterCardFactory = new CharacterCardFactory();
        EventCardFactory eventCardFactory = new EventCardFactory(characterCardFactory);
        Deck<EventCard> enemyDeck = eventCardFactory.createEnemyDeck();
        enemy = new Enemy(table, enemyDeck);
        human = new Human(eventCardFactory.createStartingDeck(), characterCardFactory.createGeneral());
        shop = new Shop(characterCardFactory.createStartingGenerators(), characterCardFactory.createStartingDefenders());
        table = new Table(client);
        battleMediator = new BattleMediator(this,  client);
        BattleComponent.addMediatorToAllComponents(battleMediator);
    }

    public void start() {
        battleMediator.startBattle();
        human.playGeneral();
        enemy.playCard();
        table.triggerGenerators();
    }

   public BattleDTO toDTO() {
        return BattleDTO.builder()
                .shopCard1(shop.peekFirstGenerator().toAttributes())
                .shopCard2(shop.peekFirstDefender().toAttributes())
                .hand(toViews2(human.getHand()))
                .discardPile(human.discardPileSize())
                .drawPile(human.drawPileSize())
                .general(human.getGeneral().toAttributes())
                .defenders(toViews(table.getByArea(Area.DEFENDERS)))
                .generators(toViews(table.getByArea(Area.GENERATORS)))
                .enemies(toViews(table.getByArea(Area.ENEMIES)))
                .enemyDraw(enemy.getDeck().peekFirst().toAttributes())
                .build();
    }
    //todo pora na powtórkę z generyków!

    List<CardAttributes> toViews(List<CharacterCard> cards) {
        return cards.stream()
                .map(c -> c.toAttributes())
                .collect(Collectors.toList());
    }

    List<CardAttributes> toViews2(List<EventCard> cards) {
        return cards.stream()
                .map(c -> c.toAttributes())
                .collect(Collectors.toList());
    }

   public Shop getShop() {
        return shop;
    }

   public Human getHuman() {
        return human;
    }

   public Table getTable() {
        return table;
    }

   public Enemy getEnemy() {
        return enemy;
    }

    public int getTurnNr() {
        return turn;
    }
}

