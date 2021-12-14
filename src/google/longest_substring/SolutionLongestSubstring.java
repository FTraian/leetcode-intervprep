package longest_substring;

import java.util.Collections;
import java.util.HashMap;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3054/
 */
public class SolutionLongestSubstring {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 2;

        while (right < n) {
            // when the slidewindow contains less than 3 characters
            hashmap.put(s.charAt(right), right++);

            // slidewindow contains 3 characters
            if (hashmap.size() == 3) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }

    public static void main(String[] args) {
        new SolutionLongestSubstring().lengthOfLongestSubstringTwoDistinct("abccbbcccaaacaca");
        new SolutionLongestSubstring().lengthOfLongestSubstringTwoDistinct("abaccc");
        new SolutionLongestSubstring().lengthOfLongestSubstringTwoDistinct("cdaba");
        new SolutionLongestSubstring().lengthOfLongestSubstringTwoDistinct("aac");
        new SolutionLongestSubstring().lengthOfLongestSubstringTwoDistinct("eceba");
        new SolutionLongestSubstring().lengthOfLongestSubstringTwoDistinct("ccaabbb");
    }

}
