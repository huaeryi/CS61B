public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dq = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> tmp = wordToDeque(word);
        while (tmp.size() > 1) {
            char first = tmp.removeFirst();
            char last = tmp.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> tmp = wordToDeque(word);
        while (tmp.size() > 1) {
            char first = tmp.removeFirst();
            char last = tmp.removeLast();
            if (cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }
}
