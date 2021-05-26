package pl.dixu.sa.server;

import pl.dixu.sa.server.cards.view.GameDTO;

public class Controller {

    private Gameplay gameplay;

    public Controller(Gameplay gameplay) {
        this.gameplay = gameplay;
    }

    public GameDTO getGameState() {
        return gameplay.getGame();
    }

}
