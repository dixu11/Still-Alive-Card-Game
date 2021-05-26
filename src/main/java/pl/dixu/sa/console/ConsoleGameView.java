package pl.dixu.sa.console;

import pl.dixu.sa.server.cards.view.GameDTO;
import pl.dixu.sa.server.cards.view.GameView;

public class ConsoleGameView extends GameView {
    public ConsoleGameView(GameDTO game) {
        super(game);
    }

    @Override
    public void display() {
        //todo
        System.out.println("Prezentacja stanu gry");
    }
}
