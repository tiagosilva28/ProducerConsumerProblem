import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    String name;
    int orderLimit;
    Container queue;


    private boolean flag = true;

    public Consumer(String name, Container queue, int orderLimit) {
        this.name = name;
        this.orderLimit = orderLimit;
        this.queue = queue;

    }

    @Override
    public void run() {
        synchronized (queue.plates) {
            while (queue.plates.size() == 0) {
                try {
                    queue.plates.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (this.orderLimit == 0) {
            return;
        }

        while (queue.plates.size() > 0) {
            synchronized (queue.plates) {
                queue.plates.removeLast();
                //queue.plates.notifyAll();
                this.orderLimit--;
                System.out.println(queue.plates + " took" + this.name);
            }
        }
    }
}
