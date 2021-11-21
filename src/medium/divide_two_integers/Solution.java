class Solution {
    public int divide(int dividend, int divisor) {
        double sign = 1;
        if (dividend < 0) {
            dividend = -dividend;
            sign = -1;
        }
        if (divisor < 0) {
            divisor = -divisor;
            sign *= -1;
        }
        return (int)(sign * Math.floor(Math.exp(Math.log(dividend) - Math.log(divisor))));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(-2147483647, -1));
        System.out.println(new Solution().divide(-2147483648, -1));
    }
}