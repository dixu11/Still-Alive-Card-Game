package pl.dixu.sa.server.core;

import pl.dixu.sa.server.battle.BattleFactory;
import pl.dixu.sa.server.engine.Engine;
import pl.dixu.sa.server.engine.LogicThread;
import pl.dixu.sa.server.view.PresenterFactory;
import pl.dixu.sa.server.view.PresenterThread;
import pl.dixu.sa.server.command.BattleCommandFactory;
import pl.dixu.sa.server.command.CommandClient;

//structure, logic, presenter and engine builder independent from GUI
public class GameFactory {

    private PresenterFactory presenterFactory;
    private Engine engine;

    public GameFactory(PresenterFactory presenterFactory) {
        this.presenterFactory = presenterFactory;
    }

    public void buildAndStartEngine() {
        LogicThread logicThread = new LogicThread();
        PresenterThread presenterThread = new PresenterThread();
        engine = new Engine(presenterThread, logicThread);
        engine.startAllThreads();
    }


    public Gameplay build() {
        //todo need mediator
        BattleCommandFactory battleCommandFactory = new BattleCommandFactory(presenterFactory);
        CommandClient client = new CommandClient(battleCommandFactory, engine);
        BattleFactory battleFactory = new BattleFactory(client);
        return new Gameplay(battleFactory);
    }

}
