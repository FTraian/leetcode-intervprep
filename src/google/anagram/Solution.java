package anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for(char c: s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        for(char c: t.toCharArray()) {
            Integer existing = map.get(c);
            if (existing == null) return false;
            if (existing.equals(1)) map.remove(c);
            else map.replace(c, existing - 1);
        }

        return map.size() == 0;
    }

}
