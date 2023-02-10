import java.awt.*;

public class Producer implements Runnable {
    String name;
    int taskLimit;
    Container queue;

    public Producer(String name, Container queue,int taskLimit) {
        this.name = name;
        this.taskLimit = taskLimit;
        this.queue = queue;

    }

    @Override
    public void run() {

    }
}
