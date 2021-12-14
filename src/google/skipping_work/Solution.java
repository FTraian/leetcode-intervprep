package skipping_work;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int solution(int[] x, int[]y) {
        if (x.length > y.length) {
            int[] tmp = y;
            y = x;
            x = tmp;
        }

        Map<Integer, Integer> occurences = new HashMap<>(x.length);
        for (int i: x) {
            occurences.merge(i, 1, Integer::sum);
        }

        for (int j: y) {
            Integer mapValue = occurences.get(j);
            if (mapValue == null) return j;
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{13, 5, 6, 2, 5}, new int[]{5, 2, 5, 13}));
        System.out.println(Solution.solution(new int[]{14, 27, 1, 4, 2, 50, 3, 1}, new int[]{2, 4, -4, 3, 1, 1, 14, 27, 50}));
    }
}
