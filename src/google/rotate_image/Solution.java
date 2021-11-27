package rotate_image;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3052/
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

}
