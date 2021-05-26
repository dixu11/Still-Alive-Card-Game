package pl.dixu.sa.server;
import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.cards.view.CardView;
import pl.dixu.sa.server.cards.view.GameDTO;
import java.util.List;
import java.util.stream.Collectors;

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

    GameDTO toDTO() {
        return GameDTO.builder()
                .shopCard1(shop.peekFirstGenerator().toView())
                .shopCard2(shop.peekFirstDefender().toView())
                .hand(toViews2(player.getHand()))
                .discardPile(player.discardPileSize())
                .drawPile(player.drawPileSize())
                .general(player.getGeneral().toView())
                .defenders(toViews(table.getByArea(Area.DEFENDERS)))
                .generators(toViews(table.getByArea(Area.GENERATORS)))
                .enemies(toViews(table.getByArea(Area.ENEMIES)))
                .enemyDraw(enemyDeck.peekFirst().toView())
                .build();
    }

    //todo pora na powtórkę z generyków!
    List<CardView> toViews(List<CharacterCard> cards){
        return cards.stream()
                .map(c-> c.toView())
                .collect(Collectors.toList());
    }

    List<CardView> toViews2(List<EventCard> cards){
        return cards.stream()
                .map(c-> c.toView())
                .collect(Collectors.toList());
    }
}

