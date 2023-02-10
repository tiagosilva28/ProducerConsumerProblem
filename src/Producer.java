import java.awt.*;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    protected String name;
    protected int taskLimit;
    protected Container queue;

    public Producer(String name, Container queue, int taskLimit) {
        this.name = name;
        this.taskLimit = taskLimit;
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue.plates) {
            while (queue.plates.size() == queue.limit) {
                try {
                    queue.plates.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (this.taskLimit == 0) {
            return;
        }

        while (queue.plates.size() < queue.limit) {
            synchronized (queue.plates) {
                queue.plates.addFirst((int) (Math.random() * (10)) + 1);
                queue.plates.notifyAll();
                this.taskLimit--;
                System.out.println(queue.plates + " " + this.name);
            }
        }
    }

}
