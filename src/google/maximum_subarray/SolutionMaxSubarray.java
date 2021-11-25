package maximum_subarray;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class SolutionMaxSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int partialSum = 0;
            for (int j = i; j < nums.length; j++) {
                partialSum += nums[j];
                max = Math.max(max, partialSum);
            }
        }
        return max;
    }

}
