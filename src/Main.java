public class Main {
    public static void main(String[] args) {
        Container<Integer> restaurant = new Container<>(10);

        Producer p1 = new Producer("Bruno o Chef", restaurant, 5);
        Thread t1 = new Thread(p1);
        //t1.setName("p1");

        Producer p2 = new Producer("Tiago o mestre", restaurant, 15);
        Thread t2 = new Thread(p2);
        //t2.setName("p2");

        Consumer c1 = new Consumer("Luisinho o comilão", restaurant, 4);
        Thread t3 = new Thread(c1);
        //t3.setName("c1");

        Consumer c2 = new Consumer("Luis Carlos o gordinho", restaurant, 7);
        Thread t4 = new Thread(c2);
        //t4.setName("c2");


        t1.start();
        t2.start();

        t3.start();
        t4.start();
    }
}