package other.number_of_1_bits;

public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        new Solution().hammingWeight(13);
    }

}