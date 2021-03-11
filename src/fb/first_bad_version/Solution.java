package fb.first_bad_version;

public class Solution {

    public int firstBadVersion(int n) {
        for(int i = n; i >=0; i--) {
            if (!isBadVersion(i)) return i + 1;
        }
        return -1;
    }

    private boolean isBadVersion(int i) {
        return false;
    }
}
