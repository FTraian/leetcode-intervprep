package fb.pow;

import javax.lang.model.util.ElementScanner14;

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

    public double myPowWiki(double x, int n) {
        // stack overflow for large numbers ?!?
        if (n < 0) return myPowWiki(1/x, -n);
        else if (n == 0) return 1;
        else if (n % 2 == 0) return myPowWiki(x * x, n / 2);
        else return x * myPowWiki(x * x, (n - 1) / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, -2147483648));
        System.out.println(new Solution().myPowWiki(2, -2147483648));
        System.out.println(Math.pow(2, -2147483648));
    }

}
