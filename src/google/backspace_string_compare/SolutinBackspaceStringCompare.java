package backspace_string_compare;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3060/
 *
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class SolutinBackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    private String processString(String s) {
        int cursor = 0;
        StringBuilder sb = new StringBuilder();

        while (cursor < s.length()) {
            if (s.charAt(cursor) == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s.charAt(cursor));
            }
            cursor++;
        }

        return sb.toString();
    }

}
