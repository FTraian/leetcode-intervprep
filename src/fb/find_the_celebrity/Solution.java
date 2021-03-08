package fb.find_the_celebrity;

public class Solution {
    public int findCelebrity(int n) {
        int[] known = new int[n];
        int[] knows = new int[n];
        for(int i = 0; i < n; knows[i] = 0, known[i++] = 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    known[j]++;
                    knows[i] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (known[i] == n - 1 && knows[i] == 0) return i;
        }
        return -1;
    }

    boolean knows(int a, int b) {
        return true;
    }
}
