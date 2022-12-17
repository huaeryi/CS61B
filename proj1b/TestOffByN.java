import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOffByN {
    static CharacterComparator offByOne5 = new OffByN(5);

    @Test
    public void testequalChars() {
        assertEquals(true, offByOne5.equalChars('a', 'f'));
        assertEquals(true, offByOne5.equalChars('f', 'a'));
        assertEquals(false, offByOne5.equalChars('a', 'a'));
    }
}
