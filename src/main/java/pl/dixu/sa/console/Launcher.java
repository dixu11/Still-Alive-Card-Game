package pl.dixu.sa.console;

import pl.dixu.sa.server.Gameplay;

public class Launcher {
    public static void main(String[] args) {
        Gameplay gameplay = new Gameplay(new ConsolePresenter());
        gameplay.startGame();
    }
}
