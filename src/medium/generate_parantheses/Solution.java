package medium.generate_parantheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        if (n > 1) {
            var rest = generateParenthesis(n - 1);
            for(String r:rest) {
                result.add("(" + r + ")");
                result.add(r + "()");
                result.add("()" + r);
            }
        } else {
            result = Set.of("()");
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
        System.out.println(new Solution().generateParenthesis(1));
    }
}
