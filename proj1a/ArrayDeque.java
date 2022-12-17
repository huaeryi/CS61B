/**
 * A Deque class implemented by Array.
 */

public class ArrayDeque<T> {

    private T[] array;
    private int capacity;
    private int first;
    private int last;
    private int size;

    public ArrayDeque() {
        capacity = 32;
        array = (T[]) new Object[capacity];
        first = capacity / 2;
        last = capacity / 2;
        size = 0;
    }

    /**
     * Resize the array.
     */
    private void grow() {
        T[] newArray = (T[]) new Object[capacity * 2];
        int p1 = first;
        int p2 = capacity;
        while (p1 != last) {
            newArray[p2] = array[p1];
            p1 = addOne(p1, capacity);
            p2 = addOne(p2, capacity * 2);
        }
        first = capacity;
        last = p2;
        array = newArray;
        capacity = capacity * 2;
    }

    private void reduce() {
        T[] newArray = (T[]) new Object[capacity / 2];
        int p1 = first;
        int p2 = capacity;
        while (p1 != last) {
            newArray[p2] = array[p1];
            p1 = addOne(p1, capacity);
            p2 = addOne(p2, capacity / 2);
        }
        first = capacity / 4;
        last = p2;
        array = newArray;
        capacity = capacity / 2;
    }



    /**
     * Add one in the array.
     */
    private int addOne(int index, int cap) {
        index = index % cap;
        if (index == cap - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    /**
     * Minus one in the array.
     */
    private int minusOne(int index) {
        if (index == 0) {
            return capacity - 1;
        }
        return index - 1;
    }

    /**
     * Add item to the first.
     */
    public void addFirst(T item) {
        if (size() == capacity - 1) {
            grow();
        }
        first = minusOne(first);
        array[first] = item;
        size += 1;
    }

    /**
     * Add item to the last.
     */
    public void addLast(T item) {
        if (size() == capacity - 1) {
            grow();
        }
        array[last] = item;
        last = addOne(last, capacity);
        size += 1;
    }

    /**
     * Return true if deque is empty,
     * else return false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the size of the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Print the item of the deque。
     */
    public void printDeque() {
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i));
            if (i < size() - 1) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    /**
     * Remove the first item of deque.
     */
    public T removeFirst() {
        if (capacity > 32 && capacity / 4 >= size) {
            reduce();
        }
        if (size() == 0) {
            return null;
        } else {
            T tmp = array[first];
            first = addOne(first, capacity);
            size -= 1;
            return tmp;
        }
    }

    /**
     * Remove the last item of deque.
     */
    public T removeLast() {
        if (capacity > 32 && capacity / 4 >= size) {
            reduce();
        }
        if (size() == 0) {
            return null;
        } else {
            T tmp = array[minusOne(last)];
            last = minusOne(last);
            size -= 1;
            return tmp;
        }
    }

    /**
     * Get the item in the position index.
     */
    public T get(int index) {
        if (index >= 0 && index < size()) {
            int target = first + index;
            if (target >= capacity) {
                target -= capacity;
            }
            return array[target];
        } else {
            return null;
        }
    }

}
