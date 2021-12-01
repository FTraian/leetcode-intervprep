package is_strobogramatic;

import java.util.Map;
import java.util.Set;

public class Solution {

    private static Map<Character, Character> stroboMirror = Map.of(
            '0', '0',
            '1','1',
            '6','9',
            '8','8',
            '9','6');

    public boolean isStrobogrammatic(String num) {
        if (num.isBlank()) return true;
        if (num.length() == 1) return Set.of("0", "1", "8").contains(num);

        Character c = stroboMirror.get(num.charAt(0));
        return c != null
                && c.equals(num.charAt(num.length() - 1))
                && (num.length() == 2 || isStrobogrammatic(num.substring(1, num.length() - 1)));
    }

    public static void main(String[] args) {
        new Solution().isStrobogrammatic("659");
    }
}
