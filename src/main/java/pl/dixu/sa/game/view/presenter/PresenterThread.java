package pl.dixu.sa.game.view.presenter;

import pl.dixu.sa.game.view.command.Command;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class PresenterThread implements Runnable {

    private BlockingQueue<Command> interactions = new LinkedBlockingQueue<>();
    private Thread thread;


    public PresenterThread() {
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                Command task = interactions.take();
                executeInteraction(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void queue(Command command) {
        interactions.add(command);
    }

    protected void executeInteraction(Command command) {
        command.executePresentation();
    }

    public void animate(Command task) {
        new Thread(() -> task.executePresentation()).start();
    }


}
