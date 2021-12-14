package numbers_station_coded_msg;

public class Solution {

    public static int[] solution(int[] l, int t) {
        int start = 0, end = 0;
        int sum = l[0];
        while (true) {
            if (sum == t) {
                return new int[]{start, end};
            }
            if (sum < t) {
                end++;
                if (end == l.length) break;
                sum += l[end];
            } else {
                sum -= l[start];
                start++;
                if (start > end) {
                    end++;
                    if (end == l.length) break;
                    sum += l[end];
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{1, 2, 3, 4}, 15)[0] + ", " + Solution.solution(new int[]{1, 2, 3, 4}, 15)[1]);
        System.out.println(Solution.solution(new int[]{1, 2, 100, 3, 4}, 7)[0] + ", " + Solution.solution(new int[]{1, 2, 100, 3, 4}, 7)[1]);
        System.out.println(Solution.solution(new int[]{4, 3, 10, 2, 8}, 12)[0] + ", " + Solution.solution(new int[]{4, 3, 10, 2, 8}, 12)[1]);
        System.out.println(Solution.solution(new int[]{4, 0, 3, 10, 2, 8}, 13)[0] + ", " + Solution.solution(new int[]{4, 0, 3, 10, 2, 8}, 13)[1]);
        System.out.println(Solution.solution(new int[]{4, 3, 10, 2, 8}, 1)[0] + ", " + Solution.solution(new int[]{4, 3, 10, 2, 8}, 1)[1]);
        System.out.println(Solution.solution(new int[]{1, 1, 18}, 18)[0] + ", " + Solution.solution(new int[]{1, 1, 18}, 18)[1]);
        System.out.println(Solution.solution(new int[]{4}, 1)[0] + ", " + Solution.solution(new int[]{4}, 1)[1]);
        System.out.println(Solution.solution(new int[]{4, 0, 0}, 4)[0] + ", " + Solution.solution(new int[]{4, 0, 0}, 4)[1]);
    }

}
