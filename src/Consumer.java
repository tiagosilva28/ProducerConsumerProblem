import java.awt.*;

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
    public void run() {

    }
}
