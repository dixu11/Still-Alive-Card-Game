package pl.dixu.sa.server.engine;

import pl.dixu.sa.server.view.PresenterThread;
import pl.dixu.sa.server.command.Command;

//tasks coordination and execution
public class Engine implements Runnable {

    private PresenterThread presenter;
    private LogicThread logic;
    private Thread serverThread;

    public Engine(PresenterThread presenter, LogicThread logic) {
        this.presenter = presenter;
        this.logic = logic;
        serverThread = new Thread(this);
    }

    public void startAllThreads() {
        serverThread.start();
        presenter.start();
        logic.start();
    }

    public void execute(Command command) {
        logic.queueLogic(command);
    }

    @Override
    public void run() {
        for (;;) {
            queuePresentationOfFinishedLogic();
        }
    }

    private void queuePresentationOfFinishedLogic() {
        Command finishedLogicCommand = logic.takeFinishedCommand();
        presenter.queuePresentationCommand(finishedLogicCommand);
    }
}
