package hard.prod_array_except_self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i=1; i<nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        int prodR = 1;
        for(int i=nums.length - 2; i>=0; i--) {
            prodR *= nums[i+1];
            output[i] *= prodR;
        }
        return output;
    }
}
