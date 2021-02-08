package hard.largest_num;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        Integer[] nint = new Integer[nums.length];
        for(int i = 0; i<nums.length; i++) {
            nint[i] = nums[i];
        }
        Arrays.sort(nint, new CustomC());

        StringBuffer sb = new StringBuffer();
        for(int i = nint.length - 1; i >= 0; i--) {
            sb.append(nint[i]);
        }
        return sb.toString();
    }

    class CustomC implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            int io1 = o1, io2 = o2;
            int diff;
            while ((diff = mostSignificativeDigit(io1) - mostSignificativeDigit(io2)) == 0) {
                if (io1 < 10 && io2 < 10) return 0;
                io1 = io1 / 10 > 0 ? io1 - largeCap(io1) : io1;
                io2 = io2 / 10 > 0 ? io2 - largeCap(io2) : io2;
            }
            return diff;
        }

        private int mostSignificativeDigit(int n) {
            return (int) (n / Math.pow(10, Math.floor(Math.log10(n))));
        }

        private int largeCap(int n) {
            return (int) (mostSignificativeDigit(n) * Math.pow(10, Math.floor(Math.log10(n))));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{10, 2}));
        System.out.println(s.largestNumber(new int[]{10}));
        System.out.println(s.largestNumber(new int[]{99, 999, 99, 2}));
        System.out.println(s.largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(s.largestNumber(new int[]{34323,3432}));
    }
}