package next_closest_time;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/471/
 */
public class SolutionNextClosestTime {

    public String nextClosestTime(String time) {
        int h1 = Integer.parseInt(time.substring(0, 1));
        int h2 = Integer.parseInt(time.substring(1, 2));
        int m1 = Integer.parseInt(time.substring(3, 4));
        int m2 = Integer.parseInt(time.substring(4, 5));

        int[] asArray = new int[]{h1, h2, -1, m1, m2};

        List<Integer> sorted = new ArrayList<>(List.of(h1, h2, m1, m2));
        sorted.sort(Integer::compareTo);

        StringBuilder sb = new StringBuilder();
        boolean possiblyFound = false;
        for (int i = 4; i >= 0; i--) {
            if (i == 2) {
                sb.append(':');
                continue;
            }
            if (possiblyFound )
            if (sorted.indexOf(asArray[i]) < sorted.size()) {
                int nextVal = sorted.get(sorted.indexOf(asArray[i]) + 1);
                if (isValid(nextVal, i)) {
                    sb.append(nextVal);
                    possiblyFound = true;
                }
            }
        }

        return "0";
    }

    private boolean isValid(int digit, int index) {
        if (index == 0) return  digit <= 2;
        if (index == 1) return digit <= 9;
        if (index == 3) return digit <= 5;
        return  digit <= 9;
    }

    public static void main(String[] args) {
        new SolutionNextClosestTime().nextClosestTime("19:31");
    }

}
