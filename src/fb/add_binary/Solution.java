package fb.add_binary;

/**
 * https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/263/
 */
public class Solution {

    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        StringBuilder result = new StringBuilder();

        byte carry = 0;
        for (byte i = 0; i < maxLen; i++) {
            byte b1 = getByte(a, i);
            byte b2 = getByte(b, i);
            byte digit = (byte) (b1 + b2 + carry);

            result.append(digit % 2);
            carry = (byte) (digit / 2);
        }
        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    private byte getByte(String s, byte pos) {
        if (pos > s.length() - 1) return 0;

        return (byte) (s.charAt(s.length() - pos - 1) - '0');
    }

}
