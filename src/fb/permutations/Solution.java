package fb.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/facebook/53/recursion-3/292/
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> input = new ArrayList<>();
        for (int e : nums) {
            input.add(e);
        }

        return backtrack(0, input, nums.length);
    }

    private List<List<Integer>> backtrack(int first, List<Integer> list, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (first == n) {
            result.add((List<Integer>) ((ArrayList)list).clone());
            return result;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(list, first, i);

            result.addAll(backtrack(first + 1, list, n));

            Collections.swap(list, first, i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1,2,3}));
    }
}
