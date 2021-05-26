package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.general.CharacterCard;
import pl.dixu.sa.server.cards.general.EventCard;
import pl.dixu.sa.server.cards.view.GameDTO;

public class Gameplay {

    private Presenter presenter;
    private Game game;

    public Gameplay(Presenter presenter) {
        this.presenter = presenter;
    }

    public void startGame() {
        GameFactory gameFactory = new GameFactory();
        game = gameFactory.createCoreGame();
        playGeneral();
        startTurn();
    }

    private void playGeneral() {
       CharacterCard general = game.playGeneral();
        presenter.playGeneral(general.toView());
    }

    public void startTurn() {
        playEnemyCard();
        //generowanie energii
        //wyciągnięcie kart
    }

    private void playEnemyCard() {
       EventCard event = game.drawEnemyEvent();
        presenter.showEnemyEvent(event.toView());
        event.execute(this);
    }

    public void spawnCharacter(CharacterCard character) {
        game.spawnCharacter(character);
        presenter.showSpawnCharacter(character.toView());
    }

    GameDTO getGame() {
        return game.toDTO();
    }
}
