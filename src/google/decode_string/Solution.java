package decode_string;

import maximum_subarray.SolutionMaxSubarray;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class Solution {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                List<Character> decodedString = new LinkedList<>();
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                // pop '[' from stack
                stack.pop();
                int k = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }

                for (int j = 0; j < k; j++) {
                    for (int l = decodedString.size() - 1; l >= 0 ; l--) {
                        stack.push(decodedString.get(l));
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        char[] result = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }

    public static void main(String[] args) {
        new Solution().decodeString("3[a]2[bc]");
    }

}
