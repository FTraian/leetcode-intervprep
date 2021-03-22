package fb.remove_parantheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/explore/interview/card/facebook/53/recursion-3/324/
 *
 * Example 1:
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 *
 * Example 2:
 *
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 *
 * Example 3:
 *
 * Input: s = ")("
 * Output: [""]
 */
public class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        LinkedList<Character> chars = new LinkedList<>();
        for(char c:s.toCharArray()) {
            chars.add(c);
        }

        if (test(chars) == 0) return List.of(s);

        List<String> distinct = hasResults(chars).stream().distinct().collect(Collectors.toList());
        int maxLen = distinct.stream().max((o1, o2) -> o1.length() - o2.length()).orElseGet(() -> "").length();
        return distinct.stream().filter(e -> e.length() == maxLen).collect(Collectors.toList());
    }

    private List<String> hasResults(LinkedList<Character> chars) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < chars.size(); i++) {
            LinkedList<Character> clone = (LinkedList<Character>) chars.clone();
            clone.remove(i);
            if (test(clone) == 0) {
                results.add(toString(clone));
            }
        }

        if (!results.isEmpty()) return results;

        for (int i = 0; i < chars.size(); i++) {
            LinkedList<Character> clone = (LinkedList<Character>) chars.clone();
            clone.remove(i);
            List<String> result = hasResults(clone);
            results.addAll(result);
        }

        return results;
    }


    private String toString(List<Character> chars) {
        StringBuilder sb = new StringBuilder();
        for(char c:chars) {
            sb.append(c);
        }

        return sb.toString();
    }

    private int test(LinkedList<Character> chars) {
        int test = 0;
        for (char c:chars) {
            if (c == '(') test ++;
            if (c == ')') test --;

            if (test < 0) return  test;
        }
        return test;
    }


    public static void main(String[] args) {
        new Solution().removeInvalidParentheses("()())()");
        new Solution().removeInvalidParentheses("n");
    }
}
