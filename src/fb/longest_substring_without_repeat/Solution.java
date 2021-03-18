package fb.longest_substring_without_repeat;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3008/
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int max = 1;


        int start = 0;
        while (start < s.length()) {
            Map<Character, Integer> presentChars = new HashMap<>();
            presentChars.put(s.charAt(start), 1);

            for (int end = start + 1; end < s.length(); end++) {
                if (presentChars.containsKey(s.charAt(end))) {
                    presentChars.put(s.charAt(end), presentChars.get(s.charAt(end)) + 1);
                    max = Math.max(max, end - start);
                    break;
                } else {
                    max = Math.max(max, end - start + 1);
                    presentChars.put(s.charAt(end), 1);
                }
            }


            Integer val = presentChars.get(s.charAt(start));
            if (val > 1) {
                presentChars.put(s.charAt(start), val - 1);
            } else {
                presentChars.remove(s.charAt(start));
            }
            start++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring(""));
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }

}
