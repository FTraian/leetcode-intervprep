package medium.letters_phone_num;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    private List<List<String>> dToL = List.of(
            List.of("a", "b", "c"),
            List.of("d", "e", "f"),
            List.of("g", "h", "i"),
            List.of("j", "k", "l"),
            List.of("m", "n", "o"),
            List.of("p", "q", "r", "s"),
            List.of("t", "u", "v"),
            List.of("w", "x", "y", "z")
            );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isBlank()) return Collections.emptyList();
        return getLetters(digits);
    }

    private List<String> getLetters(String digits) {
        int d = Integer.parseInt(digits.substring(0, 1));
        var letters = dToL.get(d - 2);

        if (digits.length() > 1) {
            var nextDigits = getLetters(digits.substring(1));

            List<String> results = new ArrayList<>(letters.size() * nextDigits.size());
            for (String l : letters) {
                for(String n : nextDigits) {
                    results.add(l.concat(n));
                }
            }

            return results;
        }
        return letters;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations(""));
        System.out.println(new Solution().letterCombinations("2"));
    }
}
