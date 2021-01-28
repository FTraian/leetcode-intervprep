package hard.prod_array_except_self;

class SolutionWithDivision {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        for(int i=0; i<nums.length; i++) {
            product *= nums[i];
        }
        int[] output = new int[nums.length];
        if (product == 0) {
            for(int i=0; i<nums.length; i++) {
                output[i] = 0;
            }
        } else {
            for(int i=0; i<nums.length; i++) {
                output[i] = product / nums[i];
            }
        }
        return output;
    }
}