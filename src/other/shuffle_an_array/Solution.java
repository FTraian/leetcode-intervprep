package other.shuffle_an_array;

import java.util.Arrays;
import java.util.Random;

class Solution {

    private int[] nums;
    private boolean[] used;
    private Random random;

    public Solution(int[] nums) {
        this.nums = new int[nums.length];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);
        used = new boolean[nums.length];
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = new int[nums.length];

        Arrays.fill(used, 0, used.length, false);
        int i = 0;
        while (i < nums.length) {
            int rIndex = random.nextInt(nums.length);
            if (!used[rIndex]) {
                used[rIndex] = true;
                result[i++] = nums[rIndex];
            }
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
