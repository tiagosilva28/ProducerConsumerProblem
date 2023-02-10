import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    protected String name;
    protected int taskLimit;
    protected Container queue;

    public Producer(String name, Container queue,int taskLimit) {
        this.name = name;
        this.taskLimit = taskLimit;
        this.queue = queue;

    }

    @Override
    public synchronized void run() {

        while (queue.plates.size() < queue.limit){
            if(this.taskLimit == 0)break;
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            queue.plates.addFirst((int) (Math.random() * (10)) +1);
            this.taskLimit--;
            notifyAll();
            System.out.println(queue.plates + " " + this.name);
        }




    }
}
