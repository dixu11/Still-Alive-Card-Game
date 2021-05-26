package pl.dixu.sa.console;

import pl.dixu.sa.server.Controller;
import pl.dixu.sa.server.Gameplay;

public class Launcher {
    public static void main(String[] args) {
        ConsolePresenter presenter = new ConsolePresenter();
        Gameplay gameplay = new Gameplay(presenter);
        Controller controller = new Controller(gameplay);
        presenter.setController(controller);
        gameplay.startGame();
    }
}
