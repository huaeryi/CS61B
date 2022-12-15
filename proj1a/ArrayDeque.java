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
        capacity = 20;
        array = (T[]) new Object[20];
        first = 0;
        last = 0;
        size = 0;
    }

    /**
     * Resize the array.
     */
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        int i = first;
        int j = 0;
        if (first < last) {
            while (i < last) {
                newArray[j] = array[i];
                i += 1;
                j += 1;
            }
        } else {
            while (i < last || i <= capacity) {
                if (i == capacity) {
                    i = 0;
                }
                newArray[j] = array[i];
                i += 1;
                j += 1;
            }
        }
        first = 0;
        last = j + 1;
        capacity = newCapacity;
        array = newArray;
    }

    /**
     * Check and resize the array.
     */
    private void checkSize() {
        if (size() > capacity / 2) {
            capacity = capacity * 2;
        }
        if (size() < capacity / 4) {
            capacity = capacity / 2;
        }
        if (capacity < 20) {
            capacity = 20;
        }
    }

    /**
     * Add item to the first.
     */
    public void addFirst(T item) {
        checkSize();
        if (first > 0) {
            first = first - 1;
            array[first] = item;
            size += 1;
        } else {
            first = capacity - 1;
            array[first] = item;
            size += 1;
        }
    }

    /**
     * Add item to the last.
     */
    public void addLast(T item) {
        checkSize();
        if (last < capacity) {
            array[last] = item;
            last = last + 1;
            size += 1;
        } else {
            last = 0;
            array[last] = item;
            last = last + 1;
            size += 1;
        }
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
        checkSize();
        if (size() == 0) {
            return null;
        } else {
            T tmp = array[first];
            first += 1;
            if (first == capacity) {
                first = 0;
            }
            size -= 1;
            return tmp;
        }
    }

    /**
     * Remove the last item of deque.
     */
    public T removeLast() {
        checkSize();
        if (size() == 0) {
            return null;
        } else {
            if (last == 0) {
                last = capacity;
            }
            T tmp = array[last - 1];
            last = last - 1;
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
