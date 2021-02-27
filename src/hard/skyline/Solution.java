package hard.skyline;

import java.awt.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 *
 *
 lefti is the x coordinate of the left edge of the ith building.
 righti is the x coordinate of the right edge of the ith building.
 heighti is the height of the ith building.
 *
 */
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Point> queue = new PriorityQueue<>(2 * buildings.length, Comparator.comparingInt(o -> o.x));
        for(int[] b:buildings) {
            queue.offer(new Point(b[0], b[2], true));
            queue.offer(new Point(b[1], b[2], false));
        }

        PriorityQueue<Integer> baselineHeight = new PriorityQueue<>((o1, o2) -> o2 - o1);
        baselineHeight.offer(0);
        List<List<Integer>> results = new LinkedList<>();
        int max = 0;
        Point p;
        while((p = queue.poll()) != null) {
            if (p.start) {
                baselineHeight.offer(p.y);
            } else {
                baselineHeight.poll();
            }

            if (p.y > max && p.start) {
                max = p.y;
                results.add(List.of(p.x, p.y));
            } else if (p.y == max && p.end()) {
                if (queue.peek() == null ||
                        (queue.peek() != null && max != queue.peek().y && p.x != queue.peek().x)) {
                    results.add(List.of(p.x, baselineHeight.peek()));
                    max = baselineHeight.peek();
                }
            }
        }

        return results;
    }

    static class Point{
        int x, y;
        boolean start;

        Point(int x, int y, boolean start) {
            this.x = x;
            this.y = y;
            this.start = start;
        }

        public boolean end() {
            return !start;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
        System.out.println(new Solution().getSkyline(new int[][]{{0,2,3},{2,5,3}}));
    }
}
