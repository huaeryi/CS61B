/**
 *
 * @param <Item>
 */

public interface Deque<Item> {

    public boolean isEmpty();

    public void addFirst(Item item);

    public void addLast(Item item);

    public int size();

    public void printDeque();

    public Item removeFirst();

    public Item removeLast();

    public Item get(int index);

}
