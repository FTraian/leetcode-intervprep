package median_two_sorted_arrays;

import java.util.Arrays;

public class Solution {

    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length == 1 && b.length == 1) return (double) (a[0] + b[0])/2;
        if (a.length == 1) return a[0];
        if (b.length == 1) return b[0];
        if (a.length == 0) return median(b);
        if (b.length == 0) return median(a);

        int aMid = a[a.length/2];
        int bMid = b[b.length/2];

        if (aMid < bMid) {
            return findMedianSortedArrays(
                    Arrays.copyOfRange(a, a.length/2, a.length),
                    Arrays.copyOfRange(b, 0, b.length/2)
            );
        }
        return findMedianSortedArrays(
                Arrays.copyOfRange(a, 0, a.length/2),
                Arrays.copyOfRange(b, b.length/2, b.length)
        );
    }

    public double median(int[] a) {
        if (a.length % 2 == 0) {
            return (double)(a[a.length / 2] + a[a.length / 2 + 1]) / 2;
        } else {
            return a[a.length / 2];
        }
    }

}
