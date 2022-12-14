/**
 * Some test to ArrayDeque.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void testisEmpty() {
        ArrayDeque<String> ad = new ArrayDeque<>();
        assertEquals(true, ad.isEmpty());
    }

    @Test
    public void testaddremove() {
        ArrayDeque<String> ad = new ArrayDeque<>();
        assertEquals(0, ad.size());

        ad.addFirst("first");
        assertEquals(1, ad.size());
        ad.addLast("last");
        assertEquals(2, ad.size());

        ad.printDeque();

        String first = ad.removeFirst();
        assertEquals("first", first);
        ad.printDeque();

        String last = ad.removeLast();
        assertEquals("last", last);

        assertEquals(0, ad.size());
    }

    public ArrayDeque<Integer> create(int[] arr) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i : arr) {
            ad.addLast(i);
        }
        return ad;
    }

    @Test
    public void test() {
        int[] tmp = {1, 2, 3, 4, 4, 5};
        ArrayDeque<Integer> ad = create(tmp);
        ad.printDeque();
    }
}
