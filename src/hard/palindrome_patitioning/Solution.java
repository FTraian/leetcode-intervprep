package hard.palindrome_patitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        return part(new ArrayList<>(), s, new ArrayList<>(), 0);
    }

    private List<List<String>> part(List<List<String>> result, String s, List<String> current, int index) {
        if (index == 0) current.clear();
        String str = "";
//        List<String> current = new ArrayList<>(temp);

        for (int i = index; i < s.length(); i++) {
            str += s.charAt(i);
            if (checkP(str)) {
                current.add(str);
                if (i + 1 < s.length()) {
                    part(result, s, current, i + 1);
                } else {
                    result.add(new ArrayList<>(current));
                }
                current.remove(str);
            }
        }
        return result;
    }

    private boolean checkP(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
        System.out.println(new Solution().partition("cdd"));
        System.out.println(new Solution().partition("cbbbcc"));
    }
}
