package pl.dixu.sa.server.engine;

import pl.dixu.sa.server.command.Command;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LogicThread implements Runnable{

    private Thread thread;
    private BlockingQueue<Command> queue = new LinkedBlockingQueue<>();
    private BlockingQueue<Command> finished = new LinkedBlockingQueue<>();

    public LogicThread() {
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        for(;;){
            try {
                executeLogic();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void executeLogic() throws InterruptedException {
        Command command = queue.take();
        command.executeLogic();
        finished.add(command);
    }

    public void queueLogic(Command command) {
        queue.add(command);
    }

    public Command takeFinishedCommand() {
        try {
            return finished.take();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Unexpected exception: " + e);
        }
    }
}
