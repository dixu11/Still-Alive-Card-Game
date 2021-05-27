package pl.dixu.sa.server.core;

import pl.dixu.sa.server.battle.BattleFactory;
import pl.dixu.sa.server.view.PresenterFactory;
import pl.dixu.sa.server.view.PresenterThread;
import pl.dixu.sa.server.command.CommandClient;

//structure, logic, presenter and engine builder independent from GUI
public class GameFactory {

    private PresenterFactory presenterFactory;
    private PresenterThread presenterThread;

    public GameFactory(PresenterFactory presenterFactory) {
        this.presenterFactory = presenterFactory;
    }

    public void buildAndStartEngine() {
        presenterThread = new PresenterThread();
        presenterThread.start();
    }

    public Gameplay build() {
        CommandClient client = new CommandClient(presenterThread, presenterFactory);
        BattleFactory battleFactory = new BattleFactory(client);
        return new Gameplay(battleFactory);
    }

}
