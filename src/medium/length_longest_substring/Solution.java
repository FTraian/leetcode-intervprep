package medium.length_longest_substring;

public class Solution {
    
    public int longestContinuousSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char previous = s.charAt(0);
        int length = 1;
        int result = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == previous + 1) {
                length++;
            } else {
                result = Math.max(result, length);
                length = 1;
            }
            previous = c;
        }
        return Math.max(result, length);
    }

    public static void main(String[] args) {
        new Solution().longestContinuousSubstring("abcde");
    }

}
