import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.Uncomment this class once you've created your Palindrome class. */
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertEquals(true, palindrome.isPalindrome(""));
        assertEquals(true, palindrome.isPalindrome("A"));
        assertEquals(true,palindrome.isPalindrome(("ABCBA")));
        assertEquals(false, palindrome.isPalindrome("dqjdhqwqsx"));
    }
}
