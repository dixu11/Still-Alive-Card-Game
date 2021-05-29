package pl.dixu.sa.game.battle;

import pl.dixu.sa.game.cards.factory.CharacterCardFactory;
import pl.dixu.sa.game.cards.factory.EventCardFactory;
import pl.dixu.sa.game.cards.general.Area;
import pl.dixu.sa.game.cards.general.CharacterCard;
import pl.dixu.sa.game.cards.general.EventCard;
import pl.dixu.sa.game.view.model.CardAttributes;
import pl.dixu.sa.game.view.model.BattleDTO;
import pl.dixu.sa.game.view.CommandClient;
import pl.dixu.sa.game.view.presenter.BattleController;
import pl.dixu.sa.game.view.presenter.PlayerDecision;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class Battle implements BattleController {

    private BattleMediator battleMediator;

    private Shop shop;
    private Human human;
    private Table table;
    private Enemy enemy;

    private BlockingQueue<PlayerDecision> decisions;

    private int turnCounter = 0;
    private boolean playerTurn = false;

    public Battle(CommandClient client) {
        createComponents(client);
    }

    private void createComponents(CommandClient client) {
        CharacterCardFactory characterCardFactory = new CharacterCardFactory();
        EventCardFactory eventCardFactory = new EventCardFactory(characterCardFactory);
        Deck<EventCard> enemyDeck = eventCardFactory.createEnemyDeck();
        enemy = new Enemy(enemyDeck);
        human = new Human(eventCardFactory.createStartingDeck(), characterCardFactory.createGeneral());
        shop = new Shop(characterCardFactory.createStartingGenerators(), characterCardFactory.createStartingDefenders());
        table = new Table();
        battleMediator = new BattleMediator(this, client);
        BattleComponent.addMediatorToAllComponents(battleMediator);
        decisions = new LinkedBlockingQueue<>();
    }

    public void begin() {
        setupPhase();
        playRound();
    }

    private void setupPhase() {
        battleMediator.startBattle();
        human.playGeneral();
    }

    private void playRound() {
        setupRound();
        play();
    }

    private void setupRound() {
        turnCounter++;
        enemy.playCard();
        table.triggerGenerators();
        human.drawCards();
    }

    private void play() {
        playerTurn = true;
        while (playerTurn) {
            executeDecision();
        }
    }

    private void executeDecision() {
        try {
            decisions.take().execute(human);
        } catch (InterruptedException e) {
            throw new IllegalStateException("wtf?");
        }
    }

    public void endTurn() {
        playerTurn = false;
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

    private List<CardAttributes> toViews(List<CharacterCard> cards) {
        return cards.stream()
                .map(c -> c.toAttributes())
                .collect(Collectors.toList());
    }

    private List<CardAttributes> toViews2(List<EventCard> cards) {
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
        return turnCounter;
    }
}

