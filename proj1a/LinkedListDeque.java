/*
 * A Deque class implemented by LinkedList.
 */

public class LinkedListDeque<T> {

    private TNode head;
    private TNode tail;
    private int size;

    public class TNode {
        public T item;
        public TNode prev;
        public TNode next;

        public TNode() { }

        public TNode(T data) {
            item = data;
        }
    }

    /**
     * Create a new empty deque.
     */
    public LinkedListDeque() {
        head = new TNode();
        tail = new TNode();

        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;

        size = 0;
    }

    /**
     * Add item to the first.
     */
    public void addFirst(T item) {
        TNode addItem = new TNode(item);
        TNode tmp = head.next;

        addItem.next = tmp;
        tmp.prev = addItem;
        head.next = addItem;
        addItem.prev = head;

        size += 1;
    }

    /**
     * Add item to the last.
     */
    public void addLast(T item) {
        TNode addItem = new TNode(item);
        TNode tmp = tail.prev;

        addItem.prev = tmp;
        tmp.next = addItem;
        tail.prev = addItem;
        addItem.next = tail;

        size += 1;
    }

    /**
     * Return true if deque is empty,
     * else return false.
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
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
        TNode tmp = head.next;
        for (int i = 0; i < size(); i += 1) {
            System.out.println(tmp.item);
            tmp = tmp.next;
        }
    }

    /**
     * Remove the first item of deque.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            TNode removed = head.next;
            TNode tmp = removed.next;
            head.next = tmp;
            tmp.prev = head;
            size -= 1;

            return removed.item;
        }
    }

    /**
     * Remove the last item of deque.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            TNode removed = tail.prev;
            TNode tmp = removed.prev;
            tail.prev = tmp;
            tmp.next = tail;

            return removed.item;
        }
    }

    /**
     * Get the item in the position index.
     */
    public T get(int index) {
        if (index >= 0 && index < size()) {
            TNode tmp = head.next;
            for (int i = 0; i < index; i += 1) {
                tmp = tmp.next;
            }
            return tmp.item;
        } else {
            return null;
        }
    }

}
