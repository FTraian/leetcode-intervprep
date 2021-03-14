package fb.strobogrammatic_number;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Example 1:
 *
 * Input: n = 2
 * Output: ["11","69","88","96"]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: ["0","1","8"]
 *
 * full description:      https://leetcode.com/explore/interview/card/facebook/53/recursion-3/3029/
 */
public class Solution {

    private static List<String> strobo1 = List.of("0", "1", "8");
    private static List<String> strobo2 = List.of("00", "11", "69", "88", "96");
    private static Map<String, String> stroboMirror = Map.of(
            "0", "0",
            "1","1",
            "6","9",
            "8","8",
            "9","6");

    public List<String> findStrobogrammatic(int n) {
        List<String> allStrobo = strobo(n, n);
        return allStrobo.stream().filter(s -> !s.startsWith("0") || s.length() == 1).collect(Collectors.toList());
    }

    public List<String> strobo(int n, int max) {
        if (n == 1) return strobo1;
        if (n == 2) return strobo2;

        List<String> partResults = strobo(n - 2, max);

        List<String> results = new ArrayList<>();
        for (String k : stroboMirror.keySet()) {
            for(String p : partResults) {
                results.add(k + p + stroboMirror.get(k));
            }
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findStrobogrammatic(4));
    }

}
