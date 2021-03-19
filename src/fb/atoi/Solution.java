package fb.atoi;

/**
 * https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3009/
 */
public class Solution {

    public int myAtoi(String s) {
        s = s.stripLeading();
        if (s.isEmpty()) return 0;
        int sign = 1;
        int currentDigit = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            currentDigit = 1;
        } else if (s.charAt(0) == '+') {
            currentDigit = 1;
        }

        long number = 0;
        while (currentDigit < s.length()) {
            if (s.charAt(currentDigit) >= '0' && s.charAt(currentDigit) <= '9') {
                number = number * 10 + s.charAt(currentDigit++) - '0';
            } else {
                break;
            }
            if (number > Integer.MAX_VALUE) break;
        }

        number *= sign;
        if (number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (number < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) number;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("42"));
    }
}
