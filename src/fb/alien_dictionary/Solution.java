package fb.alien_dictionary;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    /**
     * Example 1:
     *
     * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
     * Output: true
     * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
     *
     * Example 2:
     *
     * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
     * Output: false
     * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
     *
     * Example 3:
     *
     * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
     * Output: false
     * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        Comparator<? super String> comparator = (Comparator<String>) (o1, o2) -> {
            for(int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                int index1 = order.indexOf(o1.charAt(i));
                int index2 = order.indexOf(o2.charAt(i));
                if (index1 - index2 != 0) {
                    return index1 - index2;
                }
            }
            return o1.length() - o2.length();
        };
        for (int i = 0; i < words.length - 1; i++) {
            int compare = comparator.compare(words[i], words[i + 1]);
            if (compare > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
    }
}
