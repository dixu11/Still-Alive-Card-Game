package pl.dixu.sa;

import pl.dixu.sa.console.ConsolePresenterFactory;
import pl.dixu.sa.game.core.GameFactory;
import pl.dixu.sa.game.core.Gameplay;

public class Launcher {
    public static void main(String[] args) {
        GameFactory factory = new GameFactory(new ConsolePresenterFactory());
        factory.buildAndStartEngine();
        Gameplay game = factory.build();
        game.startGame();
    }
}
