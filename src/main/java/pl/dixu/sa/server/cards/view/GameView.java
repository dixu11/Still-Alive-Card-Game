package pl.dixu.sa.server.cards.view;

public abstract class GameView {
    private GameDTO game;

  public   GameView(GameDTO game) {
        this.game = game;
    }

    public abstract void display();
}
