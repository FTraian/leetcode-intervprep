package fb.strings_anagrams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // s: "cbaebabacd" p: "abc"
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        long pSum = 0;
        for (Character c:p.toCharArray()) {
            pSum += hash(c);
        }

        long sSum = 0;
        LinkedList<Integer> charValues = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            int sHash = hash(s.charAt(i));
            charValues.add(sHash);
            sSum += sHash;

            if (charValues.size() > p.length()) {
                int first = charValues.removeFirst();
                sSum -= first;
            }

            if (sSum == pSum) {
                result.add(i - p.length() + 1);
            }
        }

        return  result;
    }

    private int hash(char c) {
        return c + 17 * (c - 'a' + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution().findAnagrams("af", "be"));
        System.out.println(new Solution().findAnagrams("ncwbuq", "buq"));
        System.out.println(new Solution().findAnagrams("buqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxomsbuqtjencwgfyvizlhdkparxoms",
                "ncwgfyvizlhdkparxoms"));
    }

}
