package medium.sort_colors;

public class Solution {
    public void sortColors(int[] nums) {
        int[] counters = new int[3];
        for(int i = 0; i<nums.length; i++) {
            counters[nums[i]] ++;
        }
        for(int i = 0; i<nums.length; i++) {
            if (i < counters[0]) {
                nums[i] = 0;
            } else if( i < counters[0] + counters[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
