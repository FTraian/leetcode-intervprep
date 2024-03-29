package three_sum;

import java.util.*;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3049/
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(nums[i]);
            if (val == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {

                int complement = -nums[i] - nums[j];
                int noOfComplementsNeeded = 1;
                if (nums[i] == complement) noOfComplementsNeeded++;
                if (nums[j] == complement) noOfComplementsNeeded++;
                Integer elInMap = map.get(complement);
                if (elInMap != null && elInMap >= noOfComplementsNeeded) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], complement);
                    list.sort(Integer::compareTo);
                    result.add(list);
                }
            }
        }

        return List.copyOf(result);
    }


    public static void main(String[] args) {
        new Solution().threeSum(new int[]{0, 0, 0, 0});
    }
}
