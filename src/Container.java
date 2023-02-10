import java.util.ArrayDeque;
import java.util.Deque;

public class Container<T> {
    protected int limit;
    protected Deque<T> plates;

    public Container(int limit) {
        this.limit = limit;
        this.plates = new ArrayDeque<>(limit);

    }

}
