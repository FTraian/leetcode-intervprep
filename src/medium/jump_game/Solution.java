package medium.jump_game;

public class Solution {
    public boolean canJump(int[] nums) {
        return canBacktrackFromIds(nums.length - 1, nums);
    }

    private boolean canBacktrackFromIds(int idx, int[] nums) {
        for (int i = idx - 1; i >= 0; i--) {
            if (i + nums[i] >= idx) {
                if (i == 0 || canBacktrackFromIds(i, nums)) {
                    return  true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new Solution().canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
    }
}
