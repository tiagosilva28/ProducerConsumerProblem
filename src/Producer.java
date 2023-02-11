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


    private String recipeChoice() {
        switch ((int) (Math.random() * (5)) + 1) {
            case 1:
                return Recipes.FRANCESINHA;
            case 2:
                return Recipes.ESPARGUETE;
            case 3:
                return Recipes.SOPA;
            case 4:
                return Recipes.PIZZA;
            case 5:
                return Recipes.ARROZ_DE_TAMBORIL;

        }
        return "other plate";
    }

    @Override
    public void run() {
        if (this.taskLimit == queue.limit) {
            return;
        }

        while (taskLimit > 0) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (queue.plates) {
                while (queue.plates.size() == queue.limit) {
                    try {
                        queue.plates.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


                queue.plates.addFirst(recipeChoice());
                queue.plates.notifyAll();
                this.taskLimit--;
                System.out.println(queue.plates + " add " + this.name);
            }
        }
    }

}
