package maximum_subarray;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class SolutionMaxSubarray {

    public int maxSubArrayOnSquared(int[] nums) {
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

    public int maxSubArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(nums[start] < 0 && start < nums.length - 1) {
            start++;
        }
        if (start == end) {
            start = 0;
            end = nums.length - 1;
        } else {
            while (nums[end] < 0 && end > 1) {
                end--;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int partialSum = 0;
            for (int j = i; j <= end; j++) {
                partialSum += nums[j];
                max = Math.max(max, partialSum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionMaxSubarray().maxSubArray(new int[]{-1, -3, -2}));
        System.out.println(new SolutionMaxSubarray().maxSubArray(new int[]{1}));
    }

}
