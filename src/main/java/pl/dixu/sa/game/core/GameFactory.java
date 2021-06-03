package pl.dixu.sa.game.core;

import pl.dixu.sa.game.battle.BattleMediator;
import pl.dixu.sa.game.view.presenter.PresenterFactory;
import pl.dixu.sa.game.view.presenter.PresenterThread;
import pl.dixu.sa.game.view.CommandClient;

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
        BattleMediator mediator = new BattleMediator();
        CommandClient client = new CommandClient(presenterThread, presenterFactory);
        return new Gameplay(mediator, client);
    }

}
