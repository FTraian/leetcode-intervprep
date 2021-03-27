package fb.merge_intervals;

import java.util.LinkedList;

/**
 * https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/310/
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<Interval> list = new LinkedList<>();
        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }


        int i = 0;
        while (i < list.size() - 1) {
            boolean mergesExist = false;
            for (int j = i + 1; j < list.size(); j++) {
                Interval potentialMerge = list.get(i).merge(list.get(j));
                if (potentialMerge != null) {
                    list.remove(i);
                    list.remove(j - 1);
                    list.add(potentialMerge);

                    mergesExist = true;
                }
            }

            if (! mergesExist) i++;
        }

        int[][] result = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).x;
            result[i][1] = list.get(i).y;
        }

        return result;
    }

    static class Interval {
        final int x, y;

        Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Interval merge(Interval other) {
            if (x <= other.x && other.x <= y && y <= other.y) {
                return new Interval(x, other.y);
            } else if (other.x <= x && x <= other.y && other.y <= y) {
                return new Interval(other.x, y);
            } else if (x <= other.x && other.y <= y) {
                return new Interval(x, y);
            } else if (other.x <= x && y <= other.y) {
                return new Interval(other.x, other.y);
            }
            return null;
        }
    }
}
