import java.util.ArrayDeque;
import java.util.Deque;

public class Container<T> {
    protected int limit;
    protected Deque<T> plates;

    public Container(int limit) {
        this.limit = limit;
        this.plates = new ArrayDeque<>(limit);
    }

    public boolean getStateToProducer(){
        if(plates.size() < this.limit){
        return true;
        }
        return false;
    }

    public boolean getStateToConsumer(){
        if (plates.size() > 0){
            return true;
        }
        return false;
    }


}
