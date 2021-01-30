package hard.longest_consecutive_seq;

import java.util.Arrays;

class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int start = 0;
        int longest = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                start = i;
            }
            if (i - start + 1> longest) {
                longest = i - start + 1;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {1,2,0,1};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
