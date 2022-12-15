/**
 * Some test to LinkedListDeque.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListDequeTest2 {

    @Test
    public void testisEpmty() {
        LinkedListDeque<String> ld = new LinkedListDeque<>();
        assertEquals(true, ld.isEmpty());
    }

    @Test
    public void testaddremove() {
        LinkedListDeque<String> ld = new LinkedListDeque<>();
        assertEquals(0, ld.size());

        ld.addFirst("first");
        assertEquals(1, ld.size());
        ld.addLast("last");
        assertEquals(2, ld.size());

        ld.printDeque();

        String first = ld.removeFirst();
        assertEquals("first", first);
        ld.printDeque();

        String last = ld.removeLast();
        assertEquals("last", last);

        assertEquals(0, ld.size());
    }

    public LinkedListDeque<Integer> create(int[] arr) {
        LinkedListDeque<Integer> ld = new LinkedListDeque<>();
        for (int i : arr) {
            ld.addLast(i);
        }
        return ld;
    }


    @Test
    public void test() {
        int[] tmp = {1, 2, 3, 4, 4, 5,5,5,55,5,5,5,5,5,5,5,5,5,5};
        LinkedListDeque<Integer> ld = create(tmp);
        ld.printDeque();
        int x = ld.get(5);
        assertEquals(5, x);
        int y = ld.getRecursive(5);
        assertEquals(5, y);
    }

}
