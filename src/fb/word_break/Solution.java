package fb.word_break;

import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/facebook/55/dynamic-programming-3/3036/
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = wordDict.stream()
                .max((o1, o2) -> o1.length() - o2.length())
                .orElseGet(() -> "")
                .length();
        return recursiveBreak(s, wordDict, maxLen);
    }

    public boolean recursiveBreak(String s, List<String> wordDict, int maxDictLen) {
        int end = 0;
        while (end < s.length()) {
            end++;
            String current = s.substring(0, end);
            if (wordDict.contains(current)) {
                if (end == s.length()) {
                    return true;
                }
                if (recursiveBreak(s.substring(end), wordDict, maxDictLen)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("aaaaaaa", List.of("aaaa","aa")));
        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }
}
