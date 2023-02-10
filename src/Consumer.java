import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    String name;
    int orderLimit;
    Container queue;

    public Consumer(String name, Container queue, int orderLimit) {
        this.name = name;
        this.orderLimit = orderLimit;
        this.queue = queue;

    }

    @Override
    public synchronized void run() {
        while (queue.plates.size()!=0){
            if(this.orderLimit == 0)break;
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            queue.plates.removeLast();
            this.orderLimit--;
            System.out.println(queue.plates + " TAKE OFF " + this.name);
        }

        //queue.plates.removeLast();

    }
}
