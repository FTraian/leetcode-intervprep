package fb.pow;

public class Solution {

    public double myPow(double x, int n) {
        boolean positivePower = n >= 0;
        if (!positivePower) n = -n;
        double y = 1;

        while(true) {
            double t = n % 2;
            n = (int)Math.floor(n/2);

            if (t == 1) {
                y *= x;
            }
            if (n == 0) {
                break;
            }
            x *= x;
        }
        if (positivePower) {
            return y;
        } else {
            return 1 / y;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, -2147483648));
        System.out.println(Math.pow(2, -2147483648));
    }

}
