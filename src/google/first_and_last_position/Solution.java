package first_and_last_position;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int k = findOccurrence(nums, 0, nums.length - 1, target);
        if (k == -1) return new int[]{-1, -1};

        return findAround(nums, k, target);
    }

    private int[] findAround(int[] nums, int pos, int target) {
        int start = pos, end = pos;
        while (start > 0 && nums[--start] == target){
            System.out.println(start);
        };
        while (end < nums.length - 1 && nums[++end] == target) {
            System.out.println(end);
        };
        return new int[]{start == 0 ? 0: start + 1, end == nums.length -1 ? nums.length - 1: end -1};
    }

    private int findOccurrence(int[] nums, int start, int end, int target) {
        int current = nums[(start + end) / 2];
        if (current == target) return (start + end) / 2;
        if (start == end) return -1;
        if (current < target) return findOccurrence(nums, (start + end) / 2 + 1, end, target);
        return findOccurrence(nums, start, (start + end) / 2, target);
    }

    public static void main(String[] args) {
        new Solution().searchRange(new int[] {1}, 1);
        new Solution().searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6);
        new Solution().searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
    }
}
