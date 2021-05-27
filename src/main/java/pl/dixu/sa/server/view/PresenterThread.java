package pl.dixu.sa.server.view;

import pl.dixu.sa.server.command.Command;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class PresenterThread implements Runnable {

    private BlockingQueue<Command> tasks = new ArrayBlockingQueue<>(10_000);
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
                Command task = tasks.take();
                executeTask(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void queuePresentationCommand(Command task) {
        tasks.add(task);
    }

    protected void executeTask(Command task) {
        task.executePresentation();
    }

}
