package rotate_image;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3052/
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int t = -1, t1;
        int length = matrix.length - 1;
        for (int row  = 0; row <= matrix.length / 2; row++) {
            for (int column = 0; column <= matrix.length / 2; column++) {
                for (int j = 0; j < 4; j++) {
                    switch (j) {
                        case 0:
                            t = matrix[row][length - row];
                            matrix[row][length - row] = matrix[row][row];
                            break;
                        case 1:
                            t1 = matrix[length - row][length - row];
                            matrix[length - row][length - row] = t;
                            t = t1;
                            break;
                        case 2:
                            t1 = matrix[length - row][row];
                            matrix[length - row][row] = t;
                            t = t1;
                            break;
                        case 3:
                            matrix[row][row] = t;
                            break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

}
