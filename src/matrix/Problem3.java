package matrix;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    //    Link: https://leetcode.com/problems/rotate-image/

    public static void main(String[] args) {

        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        new Problem3().rotate(matrix);
//        System.out.println(Arrays.toString(ans));
    }

    public void rotate(int[][] matrix) {

        /*
        * Approch -
        * Swap elements with upper traingle with lower traingle m[i][j] <=> m[j][i]
        * Reverse every row from matrix
        *
        * TC - O(N^2)
        * SC - O(1)
        * */

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for(int left = 0; left < n/2; left++){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][n - left - 1];
                matrix[i][n - left - 1] = temp;
            }
        }
    }
}
