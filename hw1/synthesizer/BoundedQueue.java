package synthesizer;

import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{

    /**
     * @return size of the buffer
     */
    public int capacity();

    /**
     * @return number of items currently in the buffer
     */
    public int fillCount();

    /**
     * Add item x to the end.
     * @param x item added to the end
     */
    public void enqueue(T x);

    /**
     * Delete and return item from the front.
     * @return item from the front
     */
    public T dequeue();

    public T peek();

    /**
     * @return true if deque is empty.
     */
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    /**
     * @return true if deque is full.
     */
    default boolean isFull() {
        return fillCount() == capacity();
    }

}
