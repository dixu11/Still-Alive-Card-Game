package pl.dixu.sa.server.cards.view;

public abstract class GameView {
    protected GameDTO game;

    public GameView(GameDTO game) {
        this.game = game;
    }

    public GameView() {
    }

  public   void setGame(GameDTO game) {
        this.game = game;
    }

    public abstract void display();
}
